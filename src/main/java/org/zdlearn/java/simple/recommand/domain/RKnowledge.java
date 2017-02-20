package org.zdlearn.java.simple.recommand.domain;

/**
 * <p>项目名称：用户预判</p>
 * <p>包名称：  com.jd.jr.recommand.domain</p>
 * <p>类名称：  RKnowledge</p>
 * <p>类描述：  //类职责详细说明</p>
 * <p>创建人：  zhangdong147896325@163.com</p>
 * <p>创建日期：2017/2/20 </p>
 * <p>修改人:</p>
 * <p>修改日期</p>
 * <p>修改备注</p>
 * <p>@version V1.0 </p>
 * <p>@author zhangdong147896325@163.com</p>
 * <p>@see</p>
 */
public class RKnowledge {
    private Long knowledgeId;
    private String title;
    private String version;
    private int score;
    public Long getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Long knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "RKnowledge{" +
                "knowledgeId=" + knowledgeId +
                ", title='" + title + '\'' +
                ", version='" + version + '\'' +
                ", score=" + score +
                '}';
    }
}
