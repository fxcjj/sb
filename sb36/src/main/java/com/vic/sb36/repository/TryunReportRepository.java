package com.vic.sb36.repository;

import com.vic.sb36.doc.TryunReport;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * item repository
 */
public interface TryunReportRepository extends ElasticsearchRepository<TryunReport, String> {
}