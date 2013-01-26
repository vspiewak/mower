package com.github.vspiewak.mowitnow.mower.domain;

import com.github.vspiewak.mowitnow.mower.api.Engine;
import com.github.vspiewak.mowitnow.mower.api.Vehicule;
import com.github.vspiewak.mowitnow.mower.base.Move;
import com.github.vspiewak.mowitnow.mower.base.Orientation;
import com.github.vspiewak.mowitnow.mower.base.Position;
import com.github.vspiewak.mowitnow.mower.base.Rotation;
import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Mower implements Vehicule {

    /* strongs rules: start and finish with a number, a single space, a number, a single space, N or S or E or W */
    private static final Pattern PARSE_PATTERN = Pattern.compile("^(\\d+[ ]\\d+)[ ]([N|S|E|W])$");

	private Position position;
	private Orientation orientation;
	
	private Engine engine = XEngine.get();
	
	public Mower(Position p, Orientation o) {
		this.position = p;
		this.orientation = o;
	}

    @Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public Orientation getOrientation() {
		return this.orientation;
	}

	@Override
	public String print() {
		return getPosition().getX() + " " + getPosition().getY() + " " + getOrientation().getCode();
	}

	@Override
	public boolean move(Move m) {
		Position nextPosition = getPosition().next(m, getOrientation());
		this.position = engine.update(this, nextPosition);
		return getPosition().equals(nextPosition);
	}

	@Override
	public void rotate(Rotation r) {
		this.orientation = getOrientation().rotate(r);
	}

    /* not used yet */
    public static Mower parseMower(String s) throws ParseException {

        Matcher m = PARSE_PATTERN.matcher(s);

		if (s != null && m.find()) {
			Position p = Position.parsePosition(m.group(1));
			Orientation o = Orientation.parseOrientation(m.group(2));
			return new Mower(p, o);
		}

		throw new ParseException("Parse Mower error: " + s);
	}

	@Override
	public String toString() {
		return print();
	}

}
