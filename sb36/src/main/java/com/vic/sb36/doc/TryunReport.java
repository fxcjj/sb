package com.vic.sb36.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName="tryun_report", type="es_message_report")
public class TryunReport {
	
	private String id;

	private String deliverTime;
	
	private String deliverResult;

}