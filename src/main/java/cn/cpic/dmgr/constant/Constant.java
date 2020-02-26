package cn.cpic.dmgr.constant;

public class Constant {




    //SYMBOL
    public final static String UNIX_PATH_SPT = "/"; //UNIX路径分隔符
    public final static String WIN_PATH_SPT = "\\"; //WINDOWS路径分割符
    public final static String SYMBOL_UNDERLINE = "_";
    public final static String SYMBOL_DOT = ".";
    public final static String FIELD_SPT = " || ";

    public final static String EX_PREFFIX = "ex_";

    public final static String RLT_FLAG = "RLT";
    public static final String ONE_BATCH = "001";

    public final static Integer ADD_1DAY = +1;
    public final static Integer MINUS_1DAY = -1;

    public final static String DBPF_RLT_SOURCE_TABLE="DBPF_RLT_SOURCE_TABLE";
    public final static String DBPF_RLT_SOURCE_TABLE_FIELD="DBPF_RLT_SOURCE_TABLE_FIELD";
    public final static String DMGR_GTDT_JOB="DMGR_GTDT_JOB";
    public final static String DBPF_SOURCE_TABLE="DBPF_SOURCE_TABLE";
    public final static String DBPF_SOURCE_FIELD="DBPF_SOURCE_FIELD";
    public final static String DBPF_SYN_JOB="DBPF_SYN_JOB";


    //Encoding Type
    public final static String SOURCE_TABLE_CHAR_SET = "UTF-8";
    public final static String SOURCE_TABLE_ORG_CHAR_SET = "UTF-8";
    public final static String SOURCE_TABLE_END_SEPARATOR = " ||";
    public final static String SOURCE_TABLE_JAVASPLITKEY = " \\|\\| ";
    public final static String SOURCE_TABLE_HDFSPATH = "/data/in/DMGR/UTF8";

    public final static String SOURCE_FIELD_DMGR_OPERBIZ = "DMGR_OPERBIZ";
    public final static String SOURCE_FIELD_DMGR_BRANCH = "DMGR_BRANCH";
    public final static String SOURCE_FIELD_DMGR_SENT_NO = "DMGR_SENT_NO";
    public final static String SOURCE_FIELD_DMGR_SEQUENCENO = "DMGR_SEQUENCENO";

    public final static String FIELD_TYPE_REGEX = ",$|\\(\\)$";
    public final static String FIELD_TYPE_REPLACE = "";

    public final static String SYN_JOB_TYPE = "1";
    public final static String SYN_JOB_STATUS = "2";
    public final static String SYN_JOB_IS_PERIOD = "0";
    public final static String SYN_JOB_JOB_FLAG = "1";
    public final static String SYN_JOB_RUN_LEVEL = "1";

}
