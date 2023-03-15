package com.qpolla.poll.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OptionDto implements Serializable {
    private Long id;

    private String content;

    private byte[] image;

    private int voteCount;
}
