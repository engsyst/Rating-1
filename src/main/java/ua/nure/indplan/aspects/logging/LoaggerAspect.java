/**
 * 
 */
package ua.nure.indplan.aspects.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ua.nure.indplan.controller.ActivityController;

/**
 * @author Aleksandr Khriapkin
 * Determine Logger aspects
 *
 */
@Aspect
@Component
public class LoaggerAspect {
	
	Logger logger = LoggerFactory.getLogger(LoaggerAspect.class);
	  
	
	/**
	 * Logging all actions of controllers
	 */
	@Before ("execution(* ua.nure.indplan.controller..*(..))")
	  public void callControllerMethod(JoinPoint jp){

		logger.debug("Controller action: " + jp.toShortString());  
		
	  }

}
