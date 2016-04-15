package models;

import java.awt.*;

public abstract class GameObject {
    private String id;

    private Point position;

  //  protected GameObject(String id) throws GameCharacteristicOutOfRangeException {
  //      Id = id;
  //  }

  //  public GameObject(String id, Point coordinates) throws GameCharacteristicOutOfRangeException {
  //      this(id);
   //     Coordinates = coordinates;
    //}

    public String Model;

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Point Position;
    public Point getPosition() {
        return Position;
    }

    public void setPosition(Point position) {
        Position = position;
    }

    public String Id;
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Point Coordinates;
    public Point getCoordinates() {
        return Coordinates;
    }

    public void setCoordinates(Point coordinates) {
        Coordinates = coordinates;
    }
}

