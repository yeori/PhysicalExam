package pexem.domain;

import java.util.ArrayList;
import java.util.List;

import pexem.util.Filter;
import pexem.util.Mapper;
import pexem.util.Reducer;
/**
 * @author chmin.seo
 *
 */
public class PhysicalExam {

	private String title ;
	private List<StudentData> examData;
	public PhysicalExam(String title, List<StudentData> data) {
		super();
		this.title = title;
		this.examData = data;
	}
	
	/**
	 * 전체 학생의 몸무게 평균을 계산해서 반환함
	 */
	public double getAvrWeight() {
		double sum = 0;
		for(StudentData each : examData ) {
			sum += each.getWeight();
		}
		return sum / examData.size();
	}

	/**
	 * 전체 학생의 키 평균을 계산해서 반환함
	 */
	public double getAvrHeight() {
		double sum = 0;
		for(StudentData each : examData ) {
			sum += each.getHeight();
		}
		return sum / examData.size();
	}
	/**
	 * 여학생들 몸무게 평균 계산해서 반환함
	 * @return
	 */
	public double getAvrWeightGirl() {
		return 0;
	}
	
	/**
	 * 여학생들 키 평균을 계산해서 반환함
	 * @return
	 */
	public double getAvrHeightGirl() {
		return 0;
	}
	/**
	 * 남학생들 몸무게 평균 계산해서 반환함
	 * @return
	 */
	public double getAvrWeightBoy() {
		return 0;
	}
	/**
	 * 남학생들 키 평균을 계산해서 반환함
	 * @return
	 */
	public double getAvrHeightBoy() {
		return 0;
	}
	/**
	 * 여학생 BMI 수치 평균값
	 * @return
	 */
	public double getAvrBmiGirl() {
		return 0;
	}
	/**
	 * 가장 키가 큰 학생
	 * @return
	 */
	public StudentData getTallestStudent() {
		return null;
	}
	/**
	 * 가장 키가 작은 여학생
	 * @return
	 */
	public StudentData getSmallestGirl() {
		return null;
	}
	
	
	
	public List<Double> gathering (List<StudentData> src, Filter filter, Mapper mapper ) {
		List<Double> values = new ArrayList<>();
		for ( StudentData each : src ) {
			if ( filter.acceptable(each) ) {
				values.add( mapper.map(each) );
			}
		}
		return values;
	}
	
	public StudentData picking ( List<StudentData> src, Filter filter, Reducer reducer ) {
		StudentData latest = null;
		for ( StudentData each : src ) {
			if ( filter.acceptable(each) ) {
				if ( latest == null ) {
					latest = each;
				} else {
					latest = reducer.reduce(latest, each);		
				}
			}
		}
		return latest;
	}
}
