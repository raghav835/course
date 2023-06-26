@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.cms.service.*.*(..))")
    private void serviceMethods() {
    }

    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        // Log method invocation before it executes
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Executing method: " + methodName);
    }

    @AfterReturning("serviceMethods()")
    public void logAfterReturning(JoinPoint joinPoint) {
        // Log method invocation after it successfully returns
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Finished executing method: " + methodName);
    }

    // Add more advice methods as needed for different scenarios

}
