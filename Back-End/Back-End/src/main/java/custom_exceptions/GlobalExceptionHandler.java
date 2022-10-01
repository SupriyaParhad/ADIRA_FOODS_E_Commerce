package custom_exceptions;

//import org.springframework.web.bind.MethodArgumentNotValidException;

/*import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
      
	/*@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
	
	*/

//For all Validation message to be displayed as per message instead of giving inbuilt exception format
 /* @ExcpetionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String,String>> handleMethodArgsValidException(MethodArgumentNotValidException ex)
  {
	  Map<String,String> resp=new HashMap<>();
	  ex.getBindingResult().getAllErrors().forEach((error)->{
		  String fieldName=((FieldError)(error).getField();
		  String fieldName=error.getDefaultMessage();
		  String message=error.getDefaultMessage();
		  resp.put(fieldName,message);
	  })
	  return new ResponseEntity<Map<String,String>>
  }
	
//}*/
