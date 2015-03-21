package properties;

import java.util.ListResourceBundle;

public class LanguagesBundle_fr_FR extends ListResourceBundle {
	protected Object[][] contents = {
			{"Choose SLogo Language","Choisir la langue SLogo"},
			{"Turtle Image","L'image de la Tortue"},
			{"Turtle Toggle","Choisir la Tortue"},
			{"Grid Toggle","Choisir la visibilité du Grid"},
			{"Color","Couleur"},
			{"Enter","Entrée"},
			{"Toggling turtle in simulation", "Montrer la tortue dans la simulation"},
			{"Toggling grid in simulation", "Changer la grid de la simulation"},
			{"Changing background color", "Changer la couleur dans la simulation"}
	};
	
	@Override
	protected Object[][] getContents() {
		return contents;
	}
}
