import com.family.grab.Page;
import com.family.grab.Site;
import com.family.grab.Spider;
import com.family.grab.pipeline.ConsolePipeline;
import com.family.grab.pipeline.JsonFilePipeline;
import com.family.grab.processor.PageProcessor;


public class ProcessorDoubanComing implements PageProcessor {

    // ����һ��ץȡ��վ��������ã��������롢ץȡ��������Դ�����
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public static void main(String[] args) {

        Spider.create(new ProcessorDoubanComing())
                //��"https://github.com/code4craft"��ʼץ
                .addUrl("http://movie.douban.com/coming")
                        //����5���߳�ץȡ
                .addPipeline(new JsonFilePipeline("D:\\grab\\"))
                .addPipeline(new ConsolePipeline())
                .thread(5)
                        //��������
                .run();
    }

    @Override
    // process�Ƕ��������߼��ĺ��Ľӿڣ��������д��ȡ�߼�
    public void process(Page page) {
        // ���ֶ���������γ�ȡҳ����Ϣ������������
//        page.putField("author", page.getUrl().regex("https:*").toString());
        page.putField("name", page.getHtml().xpath("//*[@id=\"content\"]/h1/span[1]/text()").toString());
//        page.putField("links", page.getHtml().xpath("//div[@class=\"articleList\"]").links().regex("http://movie\\.douban\\.com\\/subject\\/[0-9]+\\/").toString());
//        if (page.getResultItems().get("name") == null) {
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        // ����������ҳ�淢�ֺ�����url��ַ��ץȡ
        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"content\"]/div/div[1]/table/tbody/").links().regex("http://movie\\.douban\\.com\\/subject\\/[0-9]+\\/").all());
//        page.addTargetRequests(page.getHtml().xpath("//div[@class=\"articleList\"]").links().regex("http://movie\\.douban\\.com\\/subject\\/[0-9]+\\/").all());
        //page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
    }

    @Override
    public Site getSite() {
        return site;
    }
}