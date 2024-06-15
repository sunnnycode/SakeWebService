package org.sake.db.store.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StoreCategory {

    // 위스키
    WHISKY("위스키", "위스키"),
    // 사케
    SAKE("사케", "사케"),
    ;


    private String display;
    private String description;

}
