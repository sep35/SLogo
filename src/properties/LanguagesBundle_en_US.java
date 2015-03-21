package properties;

import java.util.ListResourceBundle;

public class LanguagesBundle_en_US extends ListResourceBundle {
	protected Object[][] contents = {
			{"Choose SLogo Language","Choose SLogo Language"},
			{"Turtle Image","Turtle Image"},
			{"Turtle Toggle","Turtle Toggle"},
			{"Grid Toggle","Grid Toggle"},
			{"Colors","Colors"},
			{"Enter","Enter"},
			{"Toggling turtle in simulation", "Toggling turtle in simulation"},
			{"Toggling grid in simulation", "Toggling grid in simulation"},
			{"Changing background color", "Changing background color"},
			{"Pen Properties", "Pen Properties"}
	};
	
	@Override
	protected Object[][] getContents() {
		return contents;
	}
}
