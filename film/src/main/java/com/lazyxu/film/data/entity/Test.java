package com.lazyxu.film.data.entity;

import java.util.List;

/**
 * User: Lazy_xu
 * Data: 2019/07/19
 * Description:
 * FIXME
 */
public class Test {
    /**
     * code : 0
     * result : [{"bottom":[],"result":{"h":"730","img":"http://img2.jpjie.com/4946839c3cc325037e8df81cabd8765b","mode":"2","result":{"content":"","mode":"1"},"w":"730"},"template":1,"top":[]},{"bottom":{"color1":"","color2":"","desc":"","img":"","mode":"2","result":{"content":"","mode":"1"},"title":"查看更多0元免单商品"},"result":[],"template":4,"top":{"color1":"#363636","color2":"","desc":"","h":"120","img":"http://img2.jpjie.com/416c5dceedcc3fde2a61f02765724f61","title":"新人专享 0元免单","w":"730"}},{"bottom":[],"result":{"h":"654","img":"http://img2.jpjie.com/9c0fe0eaabfd420921531a618e15277e","mode":"6","result":{"content":"","mode":""},"w":"654"},"template":1,"top":[]},{"bottom":[],"result":{"img":"","mode":"1","result":{"content":"","mode":""}},"template":1,"top":[]},{"bottom":[],"result":[],"template":6,"top":{"color1":"#363636","color2":"","desc":"","h":"120","img":"http://img2.jpjie.com/416c5dceedcc3fde2a61f02765724f61","title":"全网热销 为您精选","w":"730"}},{"bottom":[],"result":{"all_page":0,"data":[],"next_page":"","show_type":1,"total":0},"template":6,"top":[]}]
     * status : success
     */

    private int code;
    private String status;
    private List<ResultBeanXX> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBeanXX> getResult() {
        return result;
    }

    public void setResult(List<ResultBeanXX> result) {
        this.result = result;
    }

    public static class ResultBeanXX {
        /**
         * bottom : []
         * result : {"h":"730","img":"http://img2.jpjie.com/4946839c3cc325037e8df81cabd8765b","mode":"2","result":{"content":"","mode":"1"},"w":"730"}
         * template : 1
         * top : []
         */

        private ResultBeanX result;
        private int template;
        private List<?> bottom;
        private List<?> top;

        public ResultBeanX getResult() {
            return result;
        }

        public void setResult(ResultBeanX result) {
            this.result = result;
        }

        public int getTemplate() {
            return template;
        }

        public void setTemplate(int template) {
            this.template = template;
        }

        public List<?> getBottom() {
            return bottom;
        }

        public void setBottom(List<?> bottom) {
            this.bottom = bottom;
        }

        public List<?> getTop() {
            return top;
        }

        public void setTop(List<?> top) {
            this.top = top;
        }

        public static class ResultBeanX {
            /**
             * h : 730
             * img : http://img2.jpjie.com/4946839c3cc325037e8df81cabd8765b
             * mode : 2
             * result : {"content":"","mode":"1"}
             * w : 730
             */

            private String h;
            private String img;
            private String mode;
            private ResultBean result;
            private String w;

            public String getH() {
                return h;
            }

            public void setH(String h) {
                this.h = h;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getMode() {
                return mode;
            }

            public void setMode(String mode) {
                this.mode = mode;
            }

            public ResultBean getResult() {
                return result;
            }

            public void setResult(ResultBean result) {
                this.result = result;
            }

            public String getW() {
                return w;
            }

            public void setW(String w) {
                this.w = w;
            }

            public static class ResultBean {
                /**
                 * content :
                 * mode : 1
                 */

                private String content;
                private String mode;

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getMode() {
                    return mode;
                }

                public void setMode(String mode) {
                    this.mode = mode;
                }
            }
        }
    }
}
