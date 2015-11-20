import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {

    // ����һ��ץȡ��վ��������ã��������롢ץȡ��������Դ�����
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    // process�Ƕ��������߼��ĺ��Ľӿڣ��������д��ȡ�߼�
    public void process(Page page) {
        // ���ֶ���������γ�ȡҳ����Ϣ������������
        page.putField("author", page.getUrl().regex("https:*").toString());
        page.putField("name", page.getHtml().xpath("//*[@id=\"js-pjax-container\"]/div/div/div[1]/h1/span[1]/text()").toString());
//        if (page.getResultItems().get("name") == null) {
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        // ����������ҳ�淢�ֺ�����url��ַ��ץȡ
        //page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new GithubRepoPageProcessor())
                //��"https://github.com/code4craft"��ʼץ
                .addUrl("https://github.com/code4craft")
                        //����5���߳�ץȡ
                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                .thread(5)
                        //��������
                .run();
    }
}