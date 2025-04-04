package com.example.service;

import com.example.entity.Media;
import com.example.model.dto.WebUserDto;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для работы с пользователями и рабочими пространствами.
 */
public interface WebUserService {

    /**
     * Получает идентификатор текущего пользователя.
     *
     * @return идентификатор пользователя
     */
    UUID getCurrentUserId();

    /**
     * Получает идентификатор текущего рабочего пространства.
     *
     * @return идентификатор рабочего пространства
     */
    UUID getCurrentWorkspaceId();

    /**
     * Получает список медиафайлов, связанных с текущим рабочим пространством.
     *
     * @return список медиафайлов
     */
    List<Media> getWorkspaceWithMedia();

    /**
     * Получает текущего пользователя.
     *
     * @return объект пользователя
     */
    WebUserDto getCurrentUser();
}
