import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class MSSTVD extends Application
{
	boolean onof = false;
	StringBuffer sbtext = new StringBuffer();
	StringBuffer result;
	String mode = "BIN";
	int base = 2;
    public void start(Stage stage) 
	{
        TextField display = new TextField();
        display.setPrefSize(280, 60);                                 //create textfield for display the operations...
        display.setEditable(false);
        display.setStyle("-fx-font-size: 24px; -fx-text-fill: BLUE; -fx-control-inner-background: #FFF8E1; -fx-border-color: #2196F3; -fx-border-width: 2px;");

        GridPane gp = new GridPane();
        gp.setPadding(new Insets(30));
        gp.setStyle("-fx-background-color: #E0F7FA;");
        gp.setHgap(5);
        gp.setVgap(5);

        Button but0 = new Button("0");
        Button but1 = new Button("1");
        Button but2 = new Button("2");
        Button but3 = new Button("3");    //creating a buttons...
        Button but4 = new Button("4");
        Button but5 = new Button("5");
        Button but6 = new Button("6");
        Button but7 = new Button("7");
        Button but8 = new Button("8");
        Button but9 = new Button("9");
		Button butclr = new Button("CLR");
		Button butdel = new Button("DEL");
		Button butA = new Button("A");
        Button butB = new Button("B");
        Button butC = new Button("C");
        Button butD = new Button("D");
        Button butE = new Button("E");
		Button butF = new Button("F");
		Button butand = new Button("AND");
        Button butor = new Button("OR");
        Button butnot = new Button("NOT");
        Button butxor = new Button("XOR");
		Button butbin = new Button("BIN");
        Button butoct = new Button("OCT");
        Button buthex = new Button("HEX");
        Button butdec = new Button("DEC"); 
        Button butans = new Button ("ANS");
        Button butonoff = new Button("ON/OFF");		
		
        Button[] buttons = {but0,but1,but2,but3,but4,but5,but6,but7,but8,but9,butclr,butdel,butA,butB,butC,butD,butE,butF,butand,butor,butxor,butnot,butonoff,butans};
        for (Button but : buttons)
		{
            but.setPrefSize(75, 50);                //give same size for all the buttons...
			but.setStyle("-fx-font-size: 16px;");   //give font size for all the buttons...
			
			String originalColor = but.getStyle();  //get default style of the button
            but.setOnMouseEntered(e -> but.setStyle("-fx-background-color: #81D4FA; -fx-text-fill: blue;"));  //if enter set this style
            but.setOnMouseExited(e -> but.setStyle(originalColor));  //if exit set the default color to the button
        }
		//display.setStyle("-fx-border-color: #2196F3;-fx-border-width: 2px;");
		
		Circle onoff = new Circle(6);
		onoff.setStyle("-fx-fill:red; -fx-stroke: red; -fx-stroke-width: 2;");
		HBox dis = new HBox(display,onoff);
        dis.setAlignment(Pos.CENTER_LEFT); 
        dis.setSpacing(5); 
		
		buthex.setPrefSize(75, 50);               
	    buthex.setStyle("-fx-font-size: 16px;"); 
        butoct.setPrefSize(75, 50);               
	    butoct.setStyle("-fx-font-size: 16px;");  
        butdec.setPrefSize(75, 50);               
	    butdec.setStyle("-fx-font-size: 16px;");  
        butbin.setPrefSize(75, 50);               
	    butbin.setStyle("-fx-font-size: 16px;");  		
		
        gp.add(dis, 0, 0, 4, 1);  //display row and col set
        gp.add(but0, 0, 1);
        gp.add(but1, 1, 1);
        gp.add(but2, 2, 1);
        gp.add(but3, 3, 1);   
        gp.add(but4, 0, 2);   //add all the buttons to gp(gridpane)
        gp.add(but5, 1, 2);
        gp.add(but6, 2, 2);
        gp.add(but7, 3, 2);
        gp.add(but8, 0, 3);
        gp.add(but9, 1, 3); 
		gp.add(butclr, 2, 3);
        gp.add(butdel, 3, 3);
		gp.add(butA, 0, 4);
        gp.add(butB, 1, 4);
        gp.add(butC, 2, 4);
        gp.add(butD, 3, 4);
        gp.add(butE, 0, 5);
        gp.add(butF, 1, 5);
		gp.add(butand, 2, 5);
        gp.add(butor, 3, 5);
        gp.add(butnot, 0, 6);
        gp.add(butxor, 1, 6);
		gp.add(butbin, 2, 6);
		gp.add(butdec, 3, 6);
        gp.add(buthex, 0, 7);
        gp.add(butoct, 1, 7);
        gp.add(butonoff, 2, 7);
		gp.add(butans,3,7);
		
		butonoff.setOnAction(e -> 
		{
        onof = !onof; 
        if (onof)
		{
        display.setText("Calculator ON");
		onoff.setStyle("-fx-fill:green; -fx-stroke: green; -fx-stroke-width: 2;");
        } 
		else {
		sbtext.delete(0, sbtext.length());
        display.setText("Calculator OFF");
		onoff.setStyle("-fx-fill:red; -fx-stroke: red; -fx-stroke-width: 2;");
        }
        });
		
		but0.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("0");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		but1.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("1");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		but2.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("2");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		but3.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("3");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		but4.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("4");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		but5.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("5");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		but6.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("6");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		but7.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("7");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		but8.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("8");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		but9.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("9");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		butA.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("A");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		butB.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("B");
			display.setText(String.valueOf(sbtext));
			}
		});
			
		butC.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("C");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		butD.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("D");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		butE.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("E");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		butF.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("F");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		butand.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("&");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		butor.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("|");
		    display.setText(String.valueOf(sbtext));
			}
		});
		
		butnot.setOnAction(e->
		{
			if(onof)
			{
			sbtext.delete(0,sbtext.length());
			sbtext.append("~");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		butxor.setOnAction(e->
		{
			if(onof)
			{
			sbtext.append("^");
			display.setText(String.valueOf(sbtext));
			}
		});
		
		butdel.setOnAction(e->
		{
			if(onof)
			{
			sbtext.delete(0, sbtext.length());
			display.setText(String.valueOf(sbtext));
			}
		});
		
		butclr.setOnAction(e->
		{
			if(onof)
			{
			 	if(sbtext.length()>=0)
			    {
				sbtext.deleteCharAt(sbtext.length()-1);
				display.setText(String.valueOf(sbtext));
				}
			}
		});
		
		butans.setOnAction(e->
		{
			if(onof)
			{
			  int index = 0;
			  String bin1 = "",bin2="";
			  int num1 = 0,num2 = 0;
			  int str = 0;
			  int flag = 0;
			  try
			  {
			  if(sbtext.toString().contains("&") || sbtext.toString().contains("^") || sbtext.toString().contains("|") ||sbtext.toString().contains("~"))
			  {
				  flag = 1;
				  if(sbtext.toString().contains("&"))
				  {
				  index = sbtext.indexOf("&");
				 
				  bin1 = sbtext.toString().substring(0,index);
                  bin2 = sbtext.toString().substring(index+1,sbtext.length());
				  
				  num1 = Integer.parseInt(bin1, base);                           //and(b,d,h)
                  num2 = Integer.parseInt(bin2, base);
				  
				  str  = (num1 & num2);
				  }
				  else
				  {
					  display.setText("Error");  
				  }
				  
				  if(sbtext.toString().contains("|"))
				  {
				  index = sbtext.indexOf("|");
				 
				  bin1 = sbtext.toString().substring(0,index);
                  bin2 = sbtext.toString().substring(index+1,sbtext.length());    //or
				  
				  num1 = Integer.parseInt(bin1, base);
                  num2 = Integer.parseInt(bin2, base);
				  
				  str  = (num1 | num2);
				  }
				  else
				  {
					  display.setText("Error");
				  }
				  
				  if(sbtext.toString().contains("^"))
				  {
				  index = sbtext.indexOf("^");
				 
				  bin1 = sbtext.toString().substring(0,index);
                  bin2 = sbtext.toString().substring(index+1,sbtext.length());      //xor
				  
				  num1 = Integer.parseInt(bin1, base);
                  num2 = Integer.parseInt(bin2, base);
				  
				  str  = (num1 ^ num2);
				  }
				  else
				  {
					  display.setText("Error");
				  }
				  
				  if(sbtext.toString().contains("~"))
				  {
					  index = sbtext.indexOf("~");
					  
					  bin1 = sbtext.toString().substring(1);
					  int num = Integer.parseInt(bin1, base);
					  
					  str = ~num;
				  }
				  else
				  {
					  display.setText("Error");
				  }
                  
				  switch(mode)
				  {
					  case "BIN" : result = new StringBuffer(Integer.toBinaryString(str));break;
					  case "DEC" : result = new StringBuffer(Integer.toString(str));break;
					  case "HEX" : result = new StringBuffer(Integer.toHexString(str).toUpperCase());break;
					  case "OCT" : result = new StringBuffer(Integer.toOctalString(str));break;
				  }
				  
				  sbtext.delete(0,sbtext.length());
				  sbtext.append(result);
				  display.setText(result.toString());
			  }
			  if(flag==0)
			  {
				  display.setText("Error");
			  }
			  }
			  catch(Exception ex)
			  {
				  display.setText("Error Invalid Input !");
				  sbtext.delete(0,sbtext.length());
				  result.delete(0,result.length());
			  }
			}
			
		});
		
		String originalcolor = but0.getStyle();
		butbin.setOnAction(e -> {
        if (onof) {
        mode = "BIN";
		base = 2;
		butbin.setStyle("-fx-border-color: blue;-fx-border-width: 2;");
		buthex.setStyle(but0.getStyle());butdec.setStyle(but0.getStyle());butoct.setStyle(but0.getStyle());
        }
        });

        butdec.setOnAction(e -> {
        if (onof) {
        mode = "DEC";
		base = 10;  
        butdec.setStyle("-fx-border-color: blue;-fx-border-width: 2;");
		buthex.setStyle(but0.getStyle());butbin.setStyle(but0.getStyle());butoct.setStyle(but0.getStyle());		
        }
        });

        butoct.setOnAction(e -> {
        if (onof) {
        mode = "OCT";
		base = 8;
		butoct.setStyle("-fx-border-color: blue;-fx-border-width: 2;");
		buthex.setStyle(but0.getStyle());butdec.setStyle(but0.getStyle());butbin.setStyle(but0.getStyle());
        }
        });

        buthex.setOnAction(e -> {
        if (onof) {
        mode = "HEX";
		base = 16;
		buthex.setStyle("-fx-border-color: blue;-fx-border-width: 2;");
		butbin.setStyle(but0.getStyle());butdec.setStyle(but0.getStyle());butoct.setStyle(but0.getStyle());
        }
        });

        Scene s = new Scene(gp, 350, 550);
        stage.setTitle("MSSTVD Programmer Calculator");
        stage.setScene(s);
        stage.show();
    }

    public static void main(String[] args) 
	{
        launch(args);
    }
}