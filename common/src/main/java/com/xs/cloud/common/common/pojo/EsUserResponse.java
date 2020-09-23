package com.xs.cloud.common.common.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Mapping;

@Document(indexName = "test-file",type = "file")
@Mapping(mappingPath= "index_file.json")
public class EsUserResponse {

    @Id
    private String id;

    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String fileName;

    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String fileContent;

    //@Field
    private String filePath;

    private Integer sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
