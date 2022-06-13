package com.nhnacademy.gateway.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class ProjectMembers {
    private Pk pk;
    private Projects projects;
    private String id;

    @EqualsAndHashCode
    @Setter
    public static class Pk implements Serializable {

        private Long userId;
        private Long projectId;

    }


}
