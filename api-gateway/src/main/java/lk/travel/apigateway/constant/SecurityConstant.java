package lk.travel.apigateway.constant;

public interface SecurityConstant {
 String JWT_SECRET_KEY_USER="960ae3c4b9ba6ba5074c25fdde23c1dd65818f7ff2bed23102072b0d293663bb";
 String JWT_SECRET_KEY_CUSTOMER="086e291c6b4e1c890d6812f6f73d7ba83125196b814d5222aa6aaf635aa0e5c9";
 String USER_URL="http://localhost:8084/api/v1/user/search/email?email=";
 String CUSTOMER_URL="http://localhost:8083/api/v1/customer/search/email?email=";
}
