package com.oms.components.media.controller;

import com.oms.bean.Media;
import com.oms.components.abstractdata.controller.ADataPageController;
import com.oms.components.abstractdata.gui.ADataListPane;
import com.oms.components.abstractdata.gui.ADataSinglePane;
import com.oms.components.cart.controller.CartController;
import com.oms.components.media.gui.UserMediaListPane;
import com.oms.serverapi.MediaApi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class UserMediaPageController extends ADataPageController<Media> {
    private CartController cartController;

    public UserMediaPageController() {
        super(MediaApi.getInstance());
    }

    public UserMediaPageController(CartController cartController) {
        this();
        setCartController(cartController);
    }

    public void setCartController(CartController cartController) {
        this.cartController = cartController;
    }

    @Override
    public ADataListPane<Media> createListPane() {
        return new UserMediaListPane(this) {
            @Override
            public void decorateSinglePane(ADataSinglePane<Media> singlePane) {
                JSpinner spin = new JSpinner();
                spin.setModel(new SpinnerNumberModel(1, 0, null, 1));
                singlePane.addDataHandlingComponent(spin);
                spin.setPreferredSize(new Dimension(100, 20));

                JButton button = new JButton("Add to cart");
                singlePane.addDataHandlingComponent(button);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (controller instanceof UserMediaPageController) {
                            ((UserMediaPageController) controller).addToCart(singlePane.getData().getId(), singlePane.getData().getTitle(), singlePane.getData().getCost(), (int) spin.getValue());
                        }
                    }
                });
            }
        };
    }

    public void addToCart(String productId, String productTitle, float productCost, int productQuantity) {
        cartController.addToCart(productId, productTitle, productCost, productQuantity);
    }
}
