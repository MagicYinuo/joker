package com.tai.joker.joker.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
public class NewsBean {


    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-07-28 13:30","title":"幼儿园老师无证驾驶被查 扬言嫁交警赖一辈子","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/B/B0/B09291CA2C33047A09DD82EBFF6DA9F4.jpg.119x83.jpg","url":"http://news.163.com/16/0728/13/BT2K3N1D00014AEF.html#f=slist"},{"ctime":"2016-07-28 13:32","title":"广东汕尾6名青少年深夜持刀劫持落单路人，作案20余宗","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/E/ED/ED20727F12D464E0737CD9DE360CB4EA.jpg.119x83.jpg","url":"http://news.163.com/16/0728/13/BT2K6VQ800014SEH.html#f=slist"},{"ctime":"2016-07-28 13:58","title":"京剧大师梅兰芳弟子、著名京剧表演艺术家李毓芳在京逝","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/0/0B/0BA7F5EB4E5BB961C0D02FA606F6D91B.jpg.119x83.jpg","url":"http://news.163.com/16/0728/13/BT2LMRC800014SEH.html#f=slist"},{"ctime":"2016-07-28 13:59","title":"台男子深夜闯越轨道被列车撞上 送医不治身亡","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/1/1B/1B83353E892BFB468405CEB42C8104FC.jpg.119x83.jpg","url":"http://news.163.com/16/0728/13/BT2LP2S500014JB6.html#f=slist"},{"ctime":"2016-07-28 14:01","title":"《英汉大词典》前主编陆谷孙去世，享年76岁","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/9/91/91E3C92D8B2227BCC550B05E42C0551A.jpg.119x83.jpg","url":"http://news.163.com/16/0728/14/BT2LS5O500014SEH.html#f=slist"},{"ctime":"2016-07-28 14:07","title":"上海人民广场免费直饮水：有人用桶装回家，还有人就地","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/8/88/88CD958AD90D06C95EECC54B2BFFECA1.jpg.119x83.jpg","url":"http://news.163.com/16/0728/14/BT2M6C6U00014SEH.html#f=slist"},{"ctime":"2016-07-28 14:16","title":"长沙一男子面中吃出蟑螂 逼女店主当场生吞","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/5/5E/5E2D8CB9E47C92CA70AF321552EEB1C2.jpg.119x83.jpg","url":"http://news.163.com/16/0728/14/BT2MOKE900011229.html#f=slist"},{"ctime":"2016-07-28 14:28","title":"交警开罚单签\u201c英文名\u201d被质疑 回应：已责令整改","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/6/60/6069C5FA02E55DE54FED32BC2860B290.jpg.119x83.jpg","url":"http://news.163.com/16/0728/14/BT2ND28M00014JB6.html#f=slist"},{"ctime":"2016-07-28 10:40","title":"男子翻窗入室偷5万元 称想做试管婴儿","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/3/38/386D19EF90F9FA737BB2419D1130CDAF.jpg.119x83.jpg","url":"http://news.163.com/16/0728/10/BT2ABH4300014AEE.html#f=slist"},{"ctime":"2016-07-28 11:03","title":"山东东营一家四口被灭门 小孩子才2岁","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/7/74/74BE40916B158CB2DD59EA279A6934A0.jpg.119x83.jpg","url":"http://news.163.com/16/0728/11/BT2BM0HC00014SEH.html#f=slist"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-07-28 13:30
     * title : 幼儿园老师无证驾驶被查 扬言嫁交警赖一辈子
     * description : 网易社会
     * picUrl : http://s.cimg.163.com/catchpic/B/B0/B09291CA2C33047A09DD82EBFF6DA9F4.jpg.119x83.jpg
     * url : http://news.163.com/16/0728/13/BT2K3N1D00014AEF.html#f=slist
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
