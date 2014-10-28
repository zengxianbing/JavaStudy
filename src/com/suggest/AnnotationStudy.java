package com.suggest;

import com.suggest.Desc.Color;

@Desc(c = Color.White)
abstract class Bird {
	public abstract Color getColor();
}

class Sparrow extends Bird {
	private Color color;

	public void setColor(Color color) {
		this.color = color;
	}

	public Sparrow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sparrow(Color color) {
		super();
		this.color = color;
	}

	@Override
	public Color getColor() {
		return color;
	}
}

enum BirdNest {
	Sparrow;

	public Bird reproduce() {
		Desc bd = Sparrow.class.getAnnotation(Desc.class);
		return bd == null ? new Sparrow() : new Sparrow(bd.c());
	}
}

public class AnnotationStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
