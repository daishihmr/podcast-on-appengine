package net.hmrradio.podcastsite.controller.validator;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.slim3.controller.ControllerConstants;
import org.slim3.controller.validator.Errors;
import org.slim3.util.ApplicationMessage;

public class DateTypeValidatorTest {

    @Test
    public void testValidate() {
        ApplicationMessage.setBundle("application", Locale.JAPAN);
        DateTypeValidator val = new DateTypeValidator("yyyy/MM/dd HH:mm:ss");

        Map<String, Object> param = new HashMap<String, Object>();
        param.put(ControllerConstants.ERRORS_KEY, new Errors());

        param.put("1", "2010/10/12 13:54:31");
        param.put("2", "2010/02/54 13:54:31");
        param.put("3", "");
        param.put("4", null);

        assertThat(val.validate(param, "1"), is(nullValue()));
        assertThat(val.validate(param, "2"), is(notNullValue()));
        assertThat(val.validate(param, "3"), is(nullValue()));
        assertThat(val.validate(param, "4"), is(nullValue()));
    }

}
