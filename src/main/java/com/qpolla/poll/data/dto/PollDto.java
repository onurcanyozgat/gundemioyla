package com.qpolla.poll.data.dto;

import com.qpolla.entry.data.entity.EntryEntity;
import com.qpolla.poll.data.EnumPollCategory;
import com.qpolla.poll.data.EnumPollStatus;
import com.qpolla.poll.data.entity.OptionEntity;
import com.qpolla.user.data.entity.UserEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PollDto {

    private Long id;

    private String title;

    private String description;

    private List<OptionDto> optionList;

    private EnumPollCategory category;

    private long votingStartDate;

    private long votingEndDate;

    private long approvedDate;

    private EnumPollStatus status;

    // TODO UserDto will be replaced
    //private UserEntity author;

    private String url;

    // TODO json error
    //private byte[] image;

}
