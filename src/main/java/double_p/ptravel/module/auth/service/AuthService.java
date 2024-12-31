package double_p.ptravel.module.auth.service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import double_p.ptravel.module.auth.dto.IntroSpectToken;
import double_p.ptravel.module.user.dto.LoginUserDto;
import double_p.ptravel.module.user.entity.User;
import double_p.ptravel.module.user.service.IUserService;
import lombok.experimental.NonFinal;

@Service
public class AuthService {
    private final IUserService userService;

    @NonFinal
    @Value("${jwt.signerKey}")
    private String signerKey;

    public AuthService (IUserService userService) {
        this.userService = userService;
    }

    public boolean introspect(IntroSpectToken introSpectToken) throws JOSEException, ParseException {
        var token = introSpectToken.getToken();
        JWSVerifier verifier = new MACVerifier(signerKey);
        SignedJWT signedJWT = SignedJWT.parse(token);
        Date expirationTime =  signedJWT.getJWTClaimsSet().getExpirationTime();
        return signedJWT.verify(verifier) && expirationTime.after(new Date());
    }

    public String login(LoginUserDto dto) {
        User user = validateUser(dto);
        if(user!= null) {
            String token = generateToken(user);
            return token;
        }
 
        System.out.println("not found");
        return null;
    }

    private User validateUser(LoginUserDto dto) {
        User user = userService.findByEmail(dto.getEmail());
        if(user != null) {
            // check password
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            if(passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
                return user;
            } else {
                // throw exception
                System.out.println("password is incorrect");
                return null;
            }
        } else {
            // throw exception
            System.out.println("can find user with that email");
            return null;
        }
    }

    private String generateToken(User user) {
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
            .subject(user.getUsername())
            .claim("userId", user.getId())
            .claim("role", user.getRole())
            .issuer("PTravel")
            .issueTime(new Date())
            .expirationTime(new Date(
                Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
            ))
            .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        try {
            jwsObject.sign(new MACSigner(signerKey));
            return jwsObject.serialize();
        } catch (JOSEException e){
            System.out.println("can not create token");
            throw new RuntimeException(e);
        }
    }
}
