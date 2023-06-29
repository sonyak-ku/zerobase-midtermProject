package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.google.gson.annotations.SerializedName;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class WifiDTO {
	@SerializedName("X_SWIFI_MGR_NO")
	private String 관리번호;
	
	@SerializedName("X_SWIFI_WRDOFC")
	private String 자치구;
	
	@SerializedName("X_SWIFI_MAIN_NM")
	private String 와이파이명;
	
	@SerializedName("X_SWIFI_ADRES1")
	private String 도로명;
	
	@SerializedName("X_SWIFI_ADRES2")
	private String 상세주소;
	
	@SerializedName("X_SWIFI_INSTL_FLOOR")
	private String 설치위치;
	
	@SerializedName("X_SWIFI_INSTL_TY")
	private String 설치유형;
	
	@SerializedName("X_SWIFI_INSTL_MBY")
	private String 설치기관;
	
	@SerializedName("X_SWIFI_SVC_SE")
	private String 서비스구분;
	
	@SerializedName("X_SWIFI_CMCWR")
	private String 망종류;
	
	@SerializedName("X_SWIFI_CNSTC_YEAR")
	private String 설치년도;
	
	@SerializedName("X_SWIFI_INOUT_DOOR")
	private String 실내구분;
	
	@SerializedName("X_SWIFI_REMARS3")
	private String 접속환경;
	
	@SerializedName("LAT")
	private String LAT_Y;
	
	@SerializedName("LNT")
	private String LNT_X;
	
	@SerializedName("WORK_DTTM")
	private String 작업일자;
}
