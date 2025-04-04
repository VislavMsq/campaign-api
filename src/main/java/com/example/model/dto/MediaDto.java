package com.example.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

/**
 * DTO для передачи информации о медиа-файле.
 */
@Data
public class MediaDto {

    /**
     * Идентификатор медиа-файла.
     */
    @JsonProperty("id")
    private UUID id;

    /**
     * Идентификатор рабочего пространства.
     */
    @JsonProperty("workspace_id")
    private UUID workspaceId;

    /**
     * Имя файла.
     */
    @JsonProperty("file_name")
    private UUID fileName;

    /**
     * Расширение файла.
     */
    @JsonProperty("file_extension")
    private String fileExtension;

    /**
     * URL для доступа к файлу.
     */
    @JsonProperty("url")
    private String url;

    /**
     * Размер файла в байтах.
     */
    @JsonProperty("size")
    private Long size;
}
