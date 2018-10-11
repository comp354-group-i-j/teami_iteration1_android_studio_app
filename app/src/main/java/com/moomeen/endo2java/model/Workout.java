package com.moomeen.endo2java.model;

import static com.moomeen.endo2java.model.Constants.*;

import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Workout {

	private Long id;
	private Duration duration;
	private Double distance;
	@JsonProperty("burgers_burned")
	private Double burgersBurned;
	private Sport sport;
	private DateTime startTime;
	private Double calories;
	private Boolean live;
	@JsonProperty("altitude_min")
	private Double altitudeMin;
	@JsonProperty("altitude_max")
	private Double altitudeMax;
	private Integer descent;
	private Integer ascent;
	@JsonProperty("owner_id")
	private Long ownerId;
	@JsonProperty("speed_avg")
	private Double speedAvg;
	@JsonProperty("speed_max")
	private Double speedMax;

	private Integer peptalks;
	private Integer likes;
	private Integer comments;
	
	@JsonProperty("polyline_encoded_small")
	private String polyLineEncoded;

	@JsonProperty("lcp_count")
    public void setLcpCount(Map<String, Object> lcpCount) {
		peptalks = (Integer) lcpCount.get("peptalks");
		likes = (Integer) lcpCount.get("likes");
		comments = (Integer) lcpCount.get("comments");
    }

	@JsonProperty("duration")
	public void setDuration(Long duration){
		this.duration = new Duration(duration * 1000);
	}

	@JsonProperty("start_time")
	public void setStartTime(String startTime){
		this.startTime = DateTime.parse(startTime, DateTimeFormat.forPattern(DATE_FORMAT).withZone(DateTimeZone.forID("America/New_York")));
	}

	public Long getId() {
		return id;
	}

	public Duration getDuration() {
		return duration;
	}

	public Double getDistance() {
		return distance;
	}

	public Double getBurgersBurned() {
		return burgersBurned;
	}

	public Sport getSport() {
		return sport;
	}

	public DateTime getStartTime() {
		return startTime;
	}

	public Double getCalories() {
		return calories;
	}

	public Boolean getLive() {
		return live;
	}

	public Double getAltitudeMin() {
		return altitudeMin;
	}

	public Double getAltitudeMax() {
		return altitudeMax;
	}

	public Integer getDescent() {
		return descent;
	}

	public Integer getAscent() {
		return ascent;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public Double getSpeedAvg() {
		return speedAvg;
	}

	public Double getSpeedMax() {
		return speedMax;
	}

	public Integer getPeptalks() {
		return peptalks;
	}

	public Integer getLikes() {
		return likes;
	}

	public Integer getComments() {
		return comments;
	}

	public String getPolyLineEncoded() {
		return polyLineEncoded;
	}

	@Override
	public String toString() {
		return String.format(
				"Sport: %s"
						+ "\nDate: %s"
						+ "\nTime: %s"
						+ "\nDuration: %.2f"
						+ "\nDistance: %.2f"
						+ "\nAverage pace: %.2f"
						+ "\nAverage speed: %.2f"
						+ "\nMax pace: %s"
						+ "\nMax speed: %.2f"
						+ "\nCalories: %.2f"
						+ "\nMin. Altitude: %.2f"
						+ "\nMax. Altitude: %.2f"
						+ "\nHydration: %s"
						+ "\n\n",
				sport.toString(),
				startTime.toString().substring(0,10),
				startTime.toString().substring(11,19),
				(double) duration.getStandardMinutes() / 60.0,
				distance / 1.609,
				duration.getStandardMinutes() / distance / 1.609,
				speedAvg,
				"WIP",
				speedMax,
				calories,
				altitudeMin,
				altitudeMax,
				"WIP"
		);
	}
}