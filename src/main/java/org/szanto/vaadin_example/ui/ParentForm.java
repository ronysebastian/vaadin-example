package org.szanto.vaadin_example.ui;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.szanto.vaadin_example.dao.ParentDAO;
import org.szanto.vaadin_example.dao.domain.Parent;
import org.vaadin.navigator.Navigator;

import com.vaadin.Application;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Configurable(preConstruction = true)
public class ParentForm extends CustomComponent implements Navigator.View {
	@AutoGenerated
	private AbsoluteLayout mainLayout;

	@AutoGenerated
	private HorizontalSplitPanel horizontalSplitPanel_2;

	@AutoGenerated
	private VerticalLayout verticalLayout_5;

	@AutoGenerated
	private ChildDetail childDetail_1;

	@AutoGenerated
	private ChildDetail childDetail_3;

	@AutoGenerated
	private VerticalLayout verticalLayout_1;

	@AutoGenerated
	private Button buttonRefresh;

	@AutoGenerated
	private Table tableParent;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private static final long serialVersionUID = -8067611696364765667L;
	
	@Autowired
	private ParentDAO parentDAO;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public ParentForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		tableParent.setSelectable(true);

		tableParent.setImmediate(true);


		// Handle selection change.
		tableParent.addListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 3760039119380574605L;

			public void valueChange(ValueChangeEvent event) {
		        //current.setValue("Selected: " + table.getValue());
				logger.debug("" + tableParent.getValue());
		    }
			
		});
		
		buttonRefresh.addListener(new Button.ClickListener() {
			
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				refreshParents();
			}
			
		});
		
		
		tableParent.addContainerProperty("First Name", String.class,  null);
		tableParent.addContainerProperty("Last Name",  String.class,  null);
		tableParent.addContainerProperty("Year",       Date.class, null);

	}
	
	private void refreshParents() {
	
		tableParent.removeAllItems();
		
		//this is the JPAContainer version 
//		JPAContainer<Parent> parents = JPAContainerFactory.make(Parent.class, parentDAO.getEntityManager());
//		tableParent.setContainerDataSource(parents);
//		tableParent.setVisibleColumns(new String[]{"firstName","lastName","dateOfBirth"});
		
		//this is the "Handmade" table population version 
		
		List<Parent> parents = parentDAO.readAllParents();
		for (Parent parent : parents) {
			Item i = tableParent.addItem(parent.getId());
			i.getItemProperty("First Name").setValue(parent.getFirstName());
			i.getItemProperty("Last Name").setValue(parent.getLastName());
			i.getItemProperty("Year").setValue(parent.getDateOfBirth());
		}
		
	}

	public void init(Navigator navigator, Application application) {
		refreshParents();
	}

	public void navigateTo(String requestedDataId) {
		
	}

	public String getWarningForNavigatingFrom() {
		return null;
	}
	
	
	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// horizontalSplitPanel_2
		horizontalSplitPanel_2 = buildHorizontalSplitPanel_2();
		mainLayout
				.addComponent(horizontalSplitPanel_2, "top:0.0px;left:0.0px;");
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalSplitPanel buildHorizontalSplitPanel_2() {
		// common part: create layout
		horizontalSplitPanel_2 = new HorizontalSplitPanel();
		horizontalSplitPanel_2.setImmediate(false);
		horizontalSplitPanel_2.setWidth("100.0%");
		horizontalSplitPanel_2.setHeight("100.0%");
		horizontalSplitPanel_2.setMargin(false);
		
		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		horizontalSplitPanel_2.addComponent(verticalLayout_1);
		
		// verticalLayout_5
		verticalLayout_5 = buildVerticalLayout_5();
		horizontalSplitPanel_2.addComponent(verticalLayout_5);
		
		return horizontalSplitPanel_2;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("100.0%");
		verticalLayout_1.setHeight("100.0%");
		verticalLayout_1.setMargin(false);
		
		// tableParent
		tableParent = new Table();
		tableParent.setImmediate(false);
		tableParent.setWidth("100.0%");
		tableParent.setHeight("100.0%");
		verticalLayout_1.addComponent(tableParent);
		verticalLayout_1.setExpandRatio(tableParent, 1.0f);
		
		// buttonRefresh
		buttonRefresh = new Button();
		buttonRefresh.setCaption("Refresh");
		buttonRefresh.setImmediate(false);
		buttonRefresh.setWidth("-1px");
		buttonRefresh.setHeight("-1px");
		verticalLayout_1.addComponent(buttonRefresh);
		
		return verticalLayout_1;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_5() {
		// common part: create layout
		verticalLayout_5 = new VerticalLayout();
		verticalLayout_5.setImmediate(false);
		verticalLayout_5.setWidth("100.0%");
		verticalLayout_5.setHeight("-1px");
		verticalLayout_5.setMargin(false);
		verticalLayout_5.setSpacing(true);
		
		// childDetail_3
		childDetail_3 = new ChildDetail();
		childDetail_3.setImmediate(false);
		childDetail_3.setWidth("100.0%");
		childDetail_3.setHeight("-1px");
		verticalLayout_5.addComponent(childDetail_3);
		
		// childDetail_1
		childDetail_1 = new ChildDetail();
		childDetail_1.setImmediate(false);
		childDetail_1.setWidth("100.0%");
		childDetail_1.setHeight("-1px");
		verticalLayout_5.addComponent(childDetail_1);
		
		return verticalLayout_5;
	}

}