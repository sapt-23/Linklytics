package com.url.shortener.repository;

import com.url.shortener.models.ClickEvent;
import com.url.shortener.models.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ClickEventRepository extends JpaRepository<ClickEvent,Long> {

    List<ClickEvent> findByUrlMappingAndClickDateBetween(UrlMapping mapping, LocalDateTime startDate, LocalDateTime endDate);
    List<ClickEvent> findByUrlMappingInAndClickDateBetween(List<UrlMapping> mapping, LocalDateTime startDate, LocalDateTime endDate);

}
