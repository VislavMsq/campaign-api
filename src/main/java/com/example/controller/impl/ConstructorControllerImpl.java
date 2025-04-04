package com.example.controller.impl;

import com.example.controller.ConstructorController;
import com.example.model.MessageStatus;
import com.example.model.MessageType;
import com.example.model.dto.CreateMessageDto;
import com.example.model.dto.GetMessageDto;
import com.example.model.dto.MessageDto;
import com.example.service.MessageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер для управления конструктором сообщений
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/constructor")
@Tag(name = "Constructor API", description = "API для создания и управления креативами (сообщениями)")
@Slf4j
public class ConstructorControllerImpl implements ConstructorController {

    private final MessageService messageService;

    @Override
    @PreAuthorize("hasAuthority('POLL_BUILDER') && hasAuthority('MESSAGE_BUILDER')")
    public GetMessageDto getById(@PathVariable("id") UUID id) {
        log.info("Получен запрос на получение креатива с ID: {}", id);
        return messageService.getById(id);
    }

    @Override
    @PreAuthorize("hasAuthority('POLL_BUILDER') && hasAuthority('MESSAGE_BUILDER')")
    public Page<GetMessageDto> getAllByType(
            @RequestParam(required = false) MessageType type,
            @RequestParam(required = false) MessageStatus status,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
        log.info("Получен запрос на получение списка креативов с параметрами: тип={}, статус={}, страница={}, размер={}",
                type, status, page, size);
        return messageService.getPageBy(type, status, page, size);
    }

    @Override
    @PreAuthorize("hasAuthority('POLL_BUILDER') && hasAuthority('MESSAGE_BUILDER')")
    public GetMessageDto update(@RequestBody CreateMessageDto object, @PathVariable("id") UUID id) {
        log.info("Получен запрос на обновление креатива с ID: {}, новые данные: {}", id, object);
        return messageService.update(object, id);
    }

    @Override
    @PreAuthorize("hasAuthority('POLL_BUILDER') && hasAuthority('MESSAGE_BUILDER')")
    public GetMessageDto create(
            @RequestParam boolean markdown,
            @RequestBody CreateMessageDto createMessageDto) {
        log.info("Получен запрос на создание креатива: {}, markdown: {}", createMessageDto, markdown);
        return messageService.create(markdown, createMessageDto);
    }

    @Override
    @PreAuthorize("hasAuthority('POLL_BUILDER') && hasAuthority('MESSAGE_BUILDER')")
    public void delete(@PathVariable("id") UUID id) {
        log.info("Получен запрос на удаление креатива с ID: {}", id);
        messageService.delete(id);
    }

    @Override
    @PreAuthorize("hasAuthority('POLL_BUILDER') && hasAuthority('MESSAGE_BUILDER')")
    public List<MessageDto> getByWorkspaceId(@RequestParam List<UUID> workspaceIds) {
        log.info("Получен запрос на получение креативов по рабочим пространствам: {}", workspaceIds);
        return messageService.getByWorkspaceId(workspaceIds);
    }
}
