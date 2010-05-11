package net.hmrradio.podcastsite.controller.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slim3.controller.validator.AbstractValidator;
import org.slim3.util.ApplicationMessage;

public class DateTypeValidator extends AbstractValidator {

    private DateFormat format;

    public DateTypeValidator(String format) {
        this.format = new SimpleDateFormat(format);
    }

    @Override
    protected String getMessageKey() {
        return "validator.dateType";
    }

    public String validate(Map<String, Object> parameters, String name) {
        Object value = parameters.get(name);
        if (value == null || "".equals(value)) {
            return null;
        } else if (value instanceof String == false) {
            return ApplicationMessage.get(getMessageKey(), getLabel(name));
        } else {
            try {
                Date d = format.parse((String) value);

                String test = format.format(d);

                if (!value.equals(test)) {
                    return ApplicationMessage.get(
                        getMessageKey(),
                        getLabel(name));
                }
            } catch (ParseException e) {
                return ApplicationMessage.get(getMessageKey(), getLabel(name));
            }
        }
        return null;
    }
}
