package org.sake.storeadmin.domain.authorization;

import lombok.RequiredArgsConstructor;
import org.sake.db.store.StoreRepository;
import org.sake.db.store.enums.StoreStatus;
import org.sake.storeadmin.domain.authorization.model.UserSession;
import org.sake.storeadmin.domain.user.service.StoreUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthorizationService implements UserDetailsService {

    private final StoreUserService storeUserService;
    private final StoreRepository storeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var storeUserEntity = storeUserService.getRegisterUser(username);

        var storeEntity = storeRepository.findFirstByIdAndStatusOrderByIdDesc(
                storeUserEntity.get().getStoreId(),
                StoreStatus.REGISTRED
        );

        return storeUserEntity.map(it ->{

                    var userSession = UserSession.builder()
                            .userId(it.getId())
                            .email(it.getEmail())
                            .password(it.getPassword())
                            .status(it.getStatus())
                            .role(it.getRole())
                            .registeredAt(it.getRegisteredAt())
                            .lastLoginAt(it.getLastLoginAt())
                            .unregisteredAt(it.getUnregisteredAt())

                            .storeId(storeEntity.get().getId())
                            .storeName(storeEntity.get().getName())
                            .build();

                    return userSession;
                })
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

}
