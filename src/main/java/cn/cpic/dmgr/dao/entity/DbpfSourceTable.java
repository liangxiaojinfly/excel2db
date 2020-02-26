package cn.cpic.dmgr.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class DbpfSourceTable implements Serializable {
    private static final long serialVersionUID = -8135299109294090297L;

    private Long id;

    private String tableName;

    private String sourceCode;

    private String sTabName;

    private String etlFrequency;

    private String desChinese;

    private Long isValid;

    private String srcFullData;

    private String onlineDate;

    private String xffs;

    private String familyName;

    private String zk;

    private String zkPort;

    private String splitkey;

    private String sqlFilter;

    private String insertFilter;

    private String charSet;

    private String deleteFilter;

    private String orgCharSet;

    private String endSeparator;

    private String javasplitkey;

    private String batchData;

    private String hdfspath;

    private String downPathFlag;

    private String sourceType;

    private String sourecPath;

    private String batchNum;

    private String deleteValue;

    private String deleteField;

    private Date createdDate;

    private String modifiedBy;

    private String createdBy;

    private Date modifiedDate;

    private String ysnBatchNum;

    private String batchDataUtf8;

    private String ysnBatchNumUtf8;

    private Long relTableId;

    private String ftpPath;

    private String fileIp;

    private String ysnGroup;

    private String checkTime;

    @Override
    public String toString() {
        return "DbpfSourceTable{" +
                "id=" + id +
                ", tableName='" + tableName + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                ", sTabName='" + sTabName + '\'' +
                ", etlFrequency='" + etlFrequency + '\'' +
                ", desChinese='" + desChinese + '\'' +
                ", isValid=" + isValid +
                ", srcFullData='" + srcFullData + '\'' +
                ", onlineDate='" + onlineDate + '\'' +
                ", xffs='" + xffs + '\'' +
                ", familyName='" + familyName + '\'' +
                ", zk='" + zk + '\'' +
                ", zkPort='" + zkPort + '\'' +
                ", splitkey='" + splitkey + '\'' +
                ", sqlFilter='" + sqlFilter + '\'' +
                ", insertFilter='" + insertFilter + '\'' +
                ", charSet='" + charSet + '\'' +
                ", deleteFilter='" + deleteFilter + '\'' +
                ", orgCharSet='" + orgCharSet + '\'' +
                ", endSeparator='" + endSeparator + '\'' +
                ", javasplitkey='" + javasplitkey + '\'' +
                ", batchData='" + batchData + '\'' +
                ", hdfspath='" + hdfspath + '\'' +
                ", downPathFlag='" + downPathFlag + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", sourecPath='" + sourecPath + '\'' +
                ", batchNum='" + batchNum + '\'' +
                ", deleteValue='" + deleteValue + '\'' +
                ", deleteField='" + deleteField + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", ysnBatchNum='" + ysnBatchNum + '\'' +
                ", batchDataUtf8='" + batchDataUtf8 + '\'' +
                ", ysnBatchNumUtf8='" + ysnBatchNumUtf8 + '\'' +
                ", relTableId=" + relTableId +
                ", ftpPath='" + ftpPath + '\'' +
                ", fileIp='" + fileIp + '\'' +
                ", ysnGroup='" + ysnGroup + '\'' +
                ", checkTime='" + checkTime + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getsTabName() {
        return sTabName;
    }

    public void setsTabName(String sTabName) {
        this.sTabName = sTabName;
    }

    public String getEtlFrequency() {
        return etlFrequency;
    }

    public void setEtlFrequency(String etlFrequency) {
        this.etlFrequency = etlFrequency;
    }

    public String getDesChinese() {
        return desChinese;
    }

    public void setDesChinese(String desChinese) {
        this.desChinese = desChinese;
    }

    public Long getIsValid() {
        return isValid;
    }

    public void setIsValid(Long isValid) {
        this.isValid = isValid;
    }

    public String getSrcFullData() {
        return srcFullData;
    }

    public void setSrcFullData(String srcFullData) {
        this.srcFullData = srcFullData;
    }

    public String getOnlineDate() {
        return onlineDate;
    }

    public void setOnlineDate(String onlineDate) {
        this.onlineDate = onlineDate;
    }

    public String getXffs() {
        return xffs;
    }

    public void setXffs(String xffs) {
        this.xffs = xffs;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getZk() {
        return zk;
    }

    public void setZk(String zk) {
        this.zk = zk;
    }

    public String getZkPort() {
        return zkPort;
    }

    public void setZkPort(String zkPort) {
        this.zkPort = zkPort;
    }

    public String getSplitkey() {
        return splitkey;
    }

    public void setSplitkey(String splitkey) {
        this.splitkey = splitkey;
    }

    public String getSqlFilter() {
        return sqlFilter;
    }

    public void setSqlFilter(String sqlFilter) {
        this.sqlFilter = sqlFilter;
    }

    public String getInsertFilter() {
        return insertFilter;
    }

    public void setInsertFilter(String insertFilter) {
        this.insertFilter = insertFilter;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public String getDeleteFilter() {
        return deleteFilter;
    }

    public void setDeleteFilter(String deleteFilter) {
        this.deleteFilter = deleteFilter;
    }

    public String getOrgCharSet() {
        return orgCharSet;
    }

    public void setOrgCharSet(String orgCharSet) {
        this.orgCharSet = orgCharSet;
    }

    public String getEndSeparator() {
        return endSeparator;
    }

    public void setEndSeparator(String endSeparator) {
        this.endSeparator = endSeparator;
    }

    public String getJavasplitkey() {
        return javasplitkey;
    }

    public void setJavasplitkey(String javasplitkey) {
        this.javasplitkey = javasplitkey;
    }

    public String getBatchData() {
        return batchData;
    }

    public void setBatchData(String batchData) {
        this.batchData = batchData;
    }

    public String getHdfspath() {
        return hdfspath;
    }

    public void setHdfspath(String hdfspath) {
        this.hdfspath = hdfspath;
    }

    public String getDownPathFlag() {
        return downPathFlag;
    }

    public void setDownPathFlag(String downPathFlag) {
        this.downPathFlag = downPathFlag;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourecPath() {
        return sourecPath;
    }

    public void setSourecPath(String sourecPath) {
        this.sourecPath = sourecPath;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getDeleteValue() {
        return deleteValue;
    }

    public void setDeleteValue(String deleteValue) {
        this.deleteValue = deleteValue;
    }

    public String getDeleteField() {
        return deleteField;
    }

    public void setDeleteField(String deleteField) {
        this.deleteField = deleteField;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getYsnBatchNum() {
        return ysnBatchNum;
    }

    public void setYsnBatchNum(String ysnBatchNum) {
        this.ysnBatchNum = ysnBatchNum;
    }

    public String getBatchDataUtf8() {
        return batchDataUtf8;
    }

    public void setBatchDataUtf8(String batchDataUtf8) {
        this.batchDataUtf8 = batchDataUtf8;
    }

    public String getYsnBatchNumUtf8() {
        return ysnBatchNumUtf8;
    }

    public void setYsnBatchNumUtf8(String ysnBatchNumUtf8) {
        this.ysnBatchNumUtf8 = ysnBatchNumUtf8;
    }

    public Long getRelTableId() {
        return relTableId;
    }

    public void setRelTableId(Long relTableId) {
        this.relTableId = relTableId;
    }

    public String getFtpPath() {
        return ftpPath;
    }

    public void setFtpPath(String ftpPath) {
        this.ftpPath = ftpPath;
    }

    public String getFileIp() {
        return fileIp;
    }

    public void setFileIp(String fileIp) {
        this.fileIp = fileIp;
    }

    public String getYsnGroup() {
        return ysnGroup;
    }

    public void setYsnGroup(String ysnGroup) {
        this.ysnGroup = ysnGroup;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }
}