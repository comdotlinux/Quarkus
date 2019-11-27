package com.linux.shower.entity;

import java.time.LocalDate;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

public class Shower {
	public LocalDate date;
	public int duration;
	public TimeUnit durationUnit;
	public String note;

	public Shower(LocalDate date, int duration, TimeUnit durationUnit, String note) {
		this.date = date;
		this.duration = duration;
		this.durationUnit = durationUnit;
		this.note = note;
	}

	public Shower() {
	}


	@Override
	public String toString() {
		return new StringJoiner(", ", Shower.class.getSimpleName() + "[", "]")
				.add("date=" + date)
				.add("duration=" + duration)
				.add("durationUnit=" + durationUnit)
				.add("note='" + note + "'")
				.toString();
	}
}
