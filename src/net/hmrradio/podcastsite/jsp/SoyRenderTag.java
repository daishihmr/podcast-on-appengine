package net.hmrradio.podcastsite.jsp;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.hmrradio.podcastsite.util.SoyUtil;

public class SoyRenderTag extends TagSupport {
    private static final long serialVersionUID = 1L;

    private String namespace;
    private String template;
    private Object value;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print(
                SoyUtil.render(namespace, template, value));
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
