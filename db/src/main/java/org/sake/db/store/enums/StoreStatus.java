package org.sake.db.store.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StoreStatus {
    REGISTRED("등록"),
    UNREGISTERED("해지")
    ;

    private String description;
}
