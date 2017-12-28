package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Film;

public class FilmWO extends WebObject
{

	private static final long	serialVersionUID	= -1377067679473844279L;

	protected int						filmId;
	protected String					title;
	protected int						duration;

	public FilmWO()
	{
		super();
	}

	public FilmWO(int filmId, String title, int duration)
	{
		super();
		this.filmId = filmId;
		this.title = title;
		this.duration = duration;
	}

	public FilmWO(final Film film)
	{
		super();
		this.filmId = film.getFilmId();
		this.title = film.getTitle();
		this.duration = film.getLength();
	}

	public int getDuration()
	{
		return duration;
	}
	
	public void setDuration(int duration)
	{
		this.duration = duration;
	}

	public int getFilmId()
	{
		return filmId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setFilmId(int filmId)
	{
		this.filmId = filmId;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	@Override
	public String toString()
	{
		return "Film [id=" + this.filmId + ", Title=" + this.title + ", Length=" + this.duration + "]";
	}
}
