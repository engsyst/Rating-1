/**
 * 
 */
package ua.nure.indplan.aspects.logging;

import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Aleksandr Khriapkin Determine Logger aspects
 *
 */
@Aspect
@Component
public class LoaggerAspect {

	Logger logger = LoggerFactory.getLogger(LoaggerAspect.class);

	/**
	 * Logging all actions of controllers
	 */
	@Before("execution(* ua.nure.indplan.controller..*(..))")
	public void callControllerMethod(JoinPoint jp) {

		Object[] params = jp.getArgs();

		StringBuilder logString = new StringBuilder();

		logString.append("Controller action: " + jp.toShortString() + " Params count:" + jp.getArgs().length + "  ");

		for (Object param : params) {

			if (param instanceof MultipartFile) {
				logString.append("MultipartFile: " + ((MultipartFile) param).getOriginalFilename() + ", ");
				continue;
			}

			if (param instanceof BindingResult) {
				logString.append("BindingResult Errors: " + "[");
				List<ObjectError> err = ((BindingResult) param).getAllErrors();
				err.forEach((v) -> logString.append(" value:" + v));
				logString.append("], ");
				continue;
			}

			if (param instanceof Model) {
				logString.append("Model: " + "[");
				Map<String, Object> map = ((Model) param).asMap();
				map.forEach((k, v) -> logString.append("key: " + k + " value:" + v));
				logString.append("], ");
				continue;
			}
			if (param instanceof RedirectAttributes) {
				logString.append("RedirectAttributes Errors: " + "[");
				List<ObjectError> err = ((BindingResult) param).getAllErrors();
				err.forEach((v) -> logString.append(" value:" + v));
				logString.append("], ");
				continue;
			}
			logString.append(param.toString() + ", ");
		}
		System.out.println(logString);

	}

}
