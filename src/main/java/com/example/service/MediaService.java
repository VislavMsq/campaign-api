package com.example.service;

import com.example.model.dto.MediaDto;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для работы с медиа-файлами.
 */
public interface MediaService {

    /**
     * Получает медиа-файл по идентификатору.
     *
     * @param id идентификатор медиа-файла
     * @return ресурс, представляющий медиа-файл
     */
    Resource getMedia(UUID id);

    /**
     * Загружает медиа-файл.
     *
     * @param file загружаемый файл
     * @param workspaceId идентификатор рабочего пространства
     * @return информация о загруженном медиа-файле
     */
    MediaDto uploadMedia(MultipartFile file, UUID workspaceId);

    /**
     * Получает все медиа-файлы текущего пользователя.
     *
     * @return список медиа-файлов
     */
    ResponseEntity<List<MediaDto>> getAllMy();

    /**
     * Получает медиа-файлы для указанных рабочих пространств.
     *
     * @param workspaceIds список идентификаторов рабочих пространств
     * @return список медиа-файлов
     */
    List<MediaDto> getByWorkspaceId(List<UUID> workspaceIds);

    /**
     * Получает медиа-файл по имени файла.
     *
     * @param fileName имя файла
     * @return массив байтов, представляющий медиа-файл
     */
    byte[] getMediaContent(UUID fileName);

    /**
     * Удаляет медиа-файл по идентификатору.
     *
     * @param id идентификатор медиа-файла
     */
    void deleteMedia(UUID id);
}
