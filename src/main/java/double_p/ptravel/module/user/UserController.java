package double_p.ptravel.module.user;

import double_p.ptravel.module.auth.dto.IntroSpectToken;
import double_p.ptravel.module.auth.service.AuthService;
import double_p.ptravel.module.user.dto.CreateUserDto;
import double_p.ptravel.module.user.dto.LoginUserDto;
import double_p.ptravel.module.user.dto.SearchUserDto;
import double_p.ptravel.module.user.dto.UpdateUserDto;
import double_p.ptravel.module.user.entity.User;
import double_p.ptravel.module.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.nimbusds.jose.JOSEException;

import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final IUserService userService;
    private final AuthService authService;

    public UserController(IUserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/getUser/{userId}")
    public Optional<User> findById(@PathVariable("userId") Long userId) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("username: {}", auth.getName());
        auth.getAuthorities().forEach(granteAuthority -> log.info(granteAuthority.getAuthority()));
        return Optional.of(userService.findById(userId).orElseThrow(() -> new RuntimeException("User not found")));
    }

    @PostMapping("/register")
    public User register(@RequestBody CreateUserDto dto) {
        return userService.create(dto);
    }

    @PostAuthorize("returnObject.id == authentication.id")
    @PatchMapping("/update/{userId}")
    public User update(
            @PathVariable("userId") Long userId,
            @RequestBody UpdateUserDto dto) {
        return userService.update(userId, dto);
    }

    @DeleteMapping("/delete/{userId}")
    public String remove(@PathVariable("userId") Long userId) {
        return userService.remove(userId);
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/all")
    public Page<User> getAllUser(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userService.findAll(pageable);
    }

    @GetMapping("/search")
    public Page<User> getMethodName(
            @RequestBody SearchUserDto dto,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userService.searchUser(dto, pageable);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginUserDto dto) {
        return authService.login(dto);
    }

    @PostMapping("/introspect")
    public boolean introspect(@RequestBody IntroSpectToken introSpectToken) throws JOSEException, ParseException {
        return authService.introspect(introSpectToken);
    }
}
