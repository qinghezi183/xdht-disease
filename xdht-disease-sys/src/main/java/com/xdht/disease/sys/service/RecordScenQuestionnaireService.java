package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordScenQuestionnaireRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordScenQuestionnaireService extends Service<RecordScenQuestionnaire> {

    /**
     * 查询列表
     * @param recordScenQuestionnaireRequest 查询条件
     * @return 返回结果
     */
    public List<RecordScenQuestionnaire> queryList(RecordScenQuestionnaireRequest recordScenQuestionnaireRequest);

    /**
     * 分页查询
     * @param recordScenQuestionnaireRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordScenQuestionnaire> queryListPage(RecordScenQuestionnaireRequest recordScenQuestionnaireRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordScenQuestionnaire 实体
     * @return 返回结果
     */
    public RecordScenQuestionnaire addRecordScenQuestionnaire(RecordScenQuestionnaire recordScenQuestionnaire);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordScenQuestionnaire deleteRecordScenQuestionnaire(Long id);

    /**
     * 修改
     * @param recordScenQuestionnaire 实体
     * @return 返回结果
     */
    public RecordScenQuestionnaire updateRecordScenQuestionnaire(RecordScenQuestionnaire recordScenQuestionnaire);
}
