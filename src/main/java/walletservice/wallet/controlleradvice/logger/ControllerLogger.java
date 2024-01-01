package walletservice.wallet.controlleradvice.logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import walletservice.wallet.models.documents.LogDocument;
import walletservice.wallet.repositories.LogMongoRepository;

import java.io.PrintWriter;
import java.io.StringWriter;

@Aspect
@Component
public class ControllerLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogger.class);
    @Autowired
    private LogMongoRepository logMongoRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Around("within(walletservice.wallet.controller.AbstractController+)")
    public Object logRestControllers(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LogDocument log = new LogDocument();
        log.setMethodName(proceedingJoinPoint.getSignature().getName());
        log.setRequest(proceedingJoinPoint.getArgs());

        Object rstValue;
        try {
            rstValue = proceedingJoinPoint.proceed();
            if (rstValue != null) {
                log.setResponse(rstValue);
            }
            logMongoRepository.save(log);
            LOGGER.info("success request" + objectMapper.writeValueAsString(log));
        } catch (Throwable e) {

            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            writer.close();
            printWriter.close();
            log.setErrorTrace(writer.toString());
            logMongoRepository.save(log);
            LOGGER.error("fail request " + objectMapper.writeValueAsString(log));
            throw e;
        }
        return rstValue;
    }


    @Pointcut("within(walletservice.wallet.service.*)")
    public void serviceMethods() {
    }

    @Before("serviceMethods()")
    public void logServiceMethods(JoinPoint joinPoint) {
        LOGGER.info("service methods called" + joinPoint.toString());
    }



//    @Around("within(walletservice.wallet.controlleradvice.*)")
//    public Object exceptionHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        LogDocument exceptionLog = new LogDocument();
//        exceptionLog.setMethodName(proceedingJoinPoint.getSignature().getName());
//        exceptionLog.setRequest(proceedingJoinPoint.getArgs());
//        Object exValue = null;
//        try {
//            exValue = proceedingJoinPoint.proceed();
//            if (exValue != null) {
//                exceptionLog.setResponse(exValue);
//            }
//            logMongoRepository.save(exceptionLog);
//            LOGGER.info("success request" + objectMapper.writeValueAsString(exceptionLog));
//        } catch (Throwable e) {
//            StringWriter writer = new StringWriter();
//            PrintWriter printWriter = new PrintWriter(writer);
//            e.printStackTrace(printWriter);
//            writer.close();
//            printWriter.close();
//            exceptionLog.setErrorTrace(writer.toString());
//            logMongoRepository.save(exceptionLog);
//            LOGGER.error("fail request " + objectMapper.writeValueAsString(exValue));
//            throw e;
//        }
//        return exValue;
//    }
//
}
