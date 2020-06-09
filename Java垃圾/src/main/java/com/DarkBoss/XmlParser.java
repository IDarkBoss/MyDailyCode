package com.darkboss;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class XmlParser {
    public static void main(String[] args) {
        //实例化
        XmlParser xmlParser = new XmlParser();
        TradeInspectionResultBO result = xmlParser.parseXml();
        System.out.println(result);
    }

    private TradeInspectionResultBO parseXml() {
        Document document = null;
        try {
            String path = this.getClass().getResource("/example.xml").getPath();
            path = URLDecoder.decode(path, StandardCharsets.UTF_8);
            File input = new File(path);
            document = Jsoup.parse(input, "UTF-8", "http://example.com/");
        } catch (Exception e) {
            log.error("读取XML文件出错", e);
        }
        TradeInspectionResultBO result = new TradeInspectionResultBO();
        List<InspectionResultBO> riskMessageList = new ArrayList<>();

        try {
            if (document != null) {
                //获取元素
                String stepMsg = document.getElementsByTag("STEP_MSG").text();
                Elements riskMsg = document.getElementsByTag("RISK_MSG");
                riskMsg.forEach(risk -> {
                    InspectionResultBO inspectionResult = new InspectionResultBO();
                    String name = risk.getElementsByTag("name").text();
                    String cntyName = risk.getElementsByTag("CNTY_NAME").text();
                    String before = risk.getElementsByTag("BEFORE").text();
                    String after = risk.getElementsByTag("AFTER").text();
                    String limit = risk.getElementsByTag("LIMIT").text();
                    String pass = risk.getElementsByTag("PASS").text();
                    String remark = risk.getElementsByTag("REMARK").text();

                    inspectionResult.setName(name);
                    inspectionResult.setQuotaObjective(cntyName);
                    inspectionResult.setCurrentValue(before);
                    inspectionResult.setPostValue(after);
                    inspectionResult.setQuotaValue(limit);
                    inspectionResult.setErrorValue("1".equals(pass) ? "0" : "1");
                    inspectionResult.setRemark(remark);

                    riskMessageList.add(inspectionResult);
                });
                result.setRiskMessages(riskMessageList);
                result.setStepMsg(stepMsg);
            } else {
                result.setRiskMessages(riskMessageList);
                result.setErrorLevel(0);
            }
        } catch (NumberFormatException e) {
            log.error("报文XML解析出错", e);
        }
        return result;
    }

    @Data
    public class TradeInspectionResultBO {
        private List<InspectionResultBO> riskMessages;
        private String serialNumber;
        /**
         * 0全通过，1不通过，2强制拒绝
         */
        private Integer errorLevel;
        private String stepMsg;
    }

    @Data
    public class InspectionResultBO {
        /**
         * 审批项目名称
         */
        private String name;

        /**
         * 检核项序号
         */
        private Integer inspectionId;
        /**
         * 检核类型: 0CMS投组,1群组,2XMS投组,3RMS,4WMS群组
         */
        private Integer quotaObjectiveType;
        /**
         * 限额对象ID
         */
        private String quotaObjectiveId;
        /**
         * 限额对象
         */
        private String quotaObjective;
        /**
         * 限额类型,1:债券类别类型,2:天期类型,3:主体对手评级,4:数值类型,5:布尔型,6:债券资产评级,7:库存类,8:数值类型（不计汇率）
         */
        private Integer quotaType;
        /**
         * 前值
         */
        private String currentValue;
        /**
         * 展示后值
         */
        private String postValue;
        /**
         * 实际前值
         */
        private String actualCurrentValue;
        /**
         * 实际后值
         */
        private String actualPostValue;
        /**
         * 限制
         */
        private String quotaValue;
        /**
         * 是否通过0-通过，1-不通过，2-强制拒绝 , （3-不在可交易券）
         */
        private String errorValue;

        /**
         * 备注
         */
        private String remark;

        /**
         * 信息说明：还本信息等
         */
        private String description;

        /**
         * 交易品种为质押式回购时，该字段为每支质押券的占额详情
         */
        private List<InspectionResultBO> repoDetails;

        /**
         * 检核内容
         */
        private String inspectionContent;

        public InspectionResultBO() {
        }

        public String getInspectionContent() {
            return inspectionContent == null ? "" : inspectionContent;
        }

        /**
         * 检核内容ID
         */
        private String inspectionContentId;

        public String getInspectionContentId() {
            return inspectionContentId == null ? "" : inspectionContentId;
        }

        /**
         * 单位
         */
        private String unit;

        /**
         * 统计口径
         */
        private Integer cumulative;

        /**
         * 是否符合检核范围
         */
        private Short inScope;

        /**
         * 交易编号
         */
        private String serialNumber;

        /**
         * 应用场景
         */
        private Integer scenario;
    }
}