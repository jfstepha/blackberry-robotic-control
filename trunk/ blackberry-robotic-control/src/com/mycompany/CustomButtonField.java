/**
 * CustomButtonField.java
 *
 * Copyright © 1998-2010 Research In Motion Ltd.
 * 
 * Note: For the sake of simplicity, this sample application may not leverage
 * resource bundles and resource strings.  However, it is STRONGLY recommended
 * that application developers make use of the localization features available
 * within the BlackBerry development platform to ensure a seamless application
 * experience across a variety of languages and geographies.  For more information
 * on localizing your application, please refer to the BlackBerry Java Development
 * Environment Development Guide associated with this release.
 */

package com.mycompany;

import net.rim.device.api.ui.*;
// import net.rim.device.api.system.*;

/**
 * CustomButtonField - class which creates button fields of various shapes.  
 * Demonstrates how to create custom ui fields.
 */
public class CustomButtonField extends Field implements DrawStyle
{
    static final int RECTANGLE = 1;
    static final int TRIANGLE = 2;
    static final int OCTAGON = 3;
    static final int FIXED_WIDTH = 4;
    static final int FULLSCREEN = 5;
    static final int COLOUR_BACKGROUND = 6;
    static final int TRIANGLE_DOWN = 7;
    static final int TRIANGLE_LEFT = 8;
    static final int TRIANGLE_RIGHT = 9;

    private String _label;
    private int _shape;
    private Font _font;
    private int _labelHeight;
    private int _labelWidth;

    /**
     * Constructs a button with specified label, and default style and shape.
     */
    public CustomButtonField(String label) 
    {
        this(label, RECTANGLE, 0);
    }

    /**
     * Constructs a button with specified label and shape, and default style.
     */
    public CustomButtonField(String label, int shape) 
    {
        this(label, shape, 0);
    }

    /**
     * Constructs a button with specified label and style, and default shape.
     */
    public CustomButtonField(String label, long style) 
    {
        this(label, RECTANGLE, style);
    }

    /**
     * Constructs a button with specified label, shape, and style.
     */
    public CustomButtonField(String label, int shape, long style) 
    {
        super(style);
        
        _label = label;
        _shape = shape;
        _font = getFont();
        _labelHeight = _font.getHeight();
        _labelWidth = _font.getAdvance(_label);
    }

    /**
     * @return The text on the button
     */
    String getText()
    {
        return _label;
    }

    /**
     * Field implementation.
     * @see net.rim.device.api.ui.Field#getPreferredWidth()
     */
    public int getPreferredWidth() 
    {
        switch(_shape)
        {
            case TRIANGLE:
                if (_labelWidth < _labelHeight) 
                {
                    return _labelHeight << 2;
                } 
                else 
                {
                    return _labelWidth << 1;
                }
                
            case TRIANGLE_DOWN:
                if (_labelWidth < _labelHeight) 
                {
                    return _labelHeight << 2;
                } 
                else 
                {
                    return _labelWidth << 1;
                }
                
            case TRIANGLE_LEFT:
                if (_labelWidth < _labelHeight) 
                {
                    return _labelHeight << 2;
                } 
                else 
                {
                    return _labelWidth << 1;
                }
            case TRIANGLE_RIGHT:
                if (_labelWidth < _labelHeight) 
                {
                    return _labelHeight << 2;
                } 
                else 
                {
                    return _labelWidth << 1;
                }
                
            case OCTAGON:
                if (_labelWidth < _labelHeight) 
                {
                    return _labelHeight + 4;
                } 
                else 
                {
                    return _labelWidth + 8;
                }
                
            case FIXED_WIDTH:
                return (_font.getAdvance(" ")) * 35; // Always set to 35 spaces wide
                
            case FULLSCREEN:
            	// Display.getWidth was the only protected API access, so fullscreen I've removed fullscreen support
            	
                // return Display.getWidth();
                return (_font.getAdvance(" ")) * 35; // Always set to 35 spaces wide
            default:
                return _labelWidth + 8;
            

        }
    }

    /**
     * Field implementation.
     * @see net.rim.device.api.ui.Field#getPreferredHeight()
     */
    public int getPreferredHeight() 
    {
        switch(_shape) 
        {
            case TRIANGLE:
                if (_labelWidth < _labelHeight) 
                {
                    return _labelHeight  << 1;
                } 
                else 
                {
                    return _labelWidth;
                }
                
            case TRIANGLE_DOWN:
                if (_labelWidth < _labelHeight) 
                {
                    return _labelHeight  << 1;
                } 
                else 
                {
                    return _labelWidth;
                }
                
            case TRIANGLE_RIGHT:
                if (_labelWidth < _labelHeight) 
                {
                    return _labelHeight  << 1;
                } 
                else 
                {
                    return _labelWidth;
                }
            case TRIANGLE_LEFT:
                if (_labelWidth < _labelHeight) 
                {
                    return _labelHeight  << 1;
                } 
                else 
                {
                    return _labelWidth;
                }
                
                
            case OCTAGON:
                return getPreferredWidth();
            
            default:
                return _labelHeight + 4;
        }
    }

    /**
     * Field implementation.
     * @see net.rim.device.api.ui.Field#drawFocus(Graphics, boolean)
     */
    protected void drawFocus(Graphics graphics, boolean on)
    {
        switch(_shape) 
        {
            case TRIANGLE:
                int w = getWidth();
                int h = w >> 1;
                
                for (int i=h-1; i>=2; --i) 
                {
                    graphics.invert(i, h - i, w - (i << 1), 1);
                }
                
                break;
                
            case TRIANGLE_DOWN:
                int w2 = getWidth();
                int h2 = w2 >> 1;
                
                for (int i=h2-1; i>=2; --i) 
                {
                    graphics.invert(i, i, w2 - (i << 1), 1);
                }
                
                break;

            case TRIANGLE_LEFT:
                int w3 = getWidth();
                int h3 = w3 >> 1; 
                
                for (int i=1; i <= (h3-1) >> 1; ++i) 
                {
                    graphics.invert(w3 - (i << 2) , i, i << 2, 1);
                }
                
                for (int i=1; i <= (h3-1) >> 1; ++i) 
                {
                    graphics.invert(i << 2, i + ((h3-1) >> 1), w3 - (i <<2) , 1);
                }
               
                
                break;
                
            case TRIANGLE_RIGHT:
                int w4 = getWidth();
                int h4 = w4 >> 1;
                
                for (int i=1; i <= (h4-1) >> 1; ++i) 
                {
                    graphics.invert(1, i, i << 2 , 1);
                }
                
                for (int i=1; i <= (h4-1) >> 1; ++i) 
                {
                    graphics.invert(1, i + ((h4-1) >> 1), w4 - (i <<2) , 1);
                }
               
                break;   
                
            case OCTAGON:
                int x3 = getWidth();
                int x = 5 * x3 / 17;
                int x2 = x3 - x;
                x3 = x3 - 1;
                x2 = x2 - 1;
                
                graphics.invert(1, x, getWidth() - 2, x2 - x + 1);

                for (int i=1; i<x; ++i) 
                {
                    graphics.invert(1+i, x-i, getWidth() - ((i+1)<<1), 1);
                    graphics.invert(1+i, x2+i, getWidth() - ((i+1)<<1), 1);
                }
                
                break;
                
            default:
                graphics.invert(1, 1, getWidth() - 2, getHeight() - 2);
                break;
        }
    }
    
    /**
     * Field implementation.
     * @see net.rim.device.api.ui.Field#layout(int, int)
     */
    protected void layout(int width, int height) 
    {
        // Update the cached font - in case it has been changed.
        _font = getFont();
        _labelHeight = _font.getHeight();
        _labelWidth = _font.getAdvance(_label);

        // Calc width.
        width = Math.min( width, getPreferredWidth() );

        // Calc height.
        height = Math.min( height, getPreferredHeight() );

        // Set dimensions.
        setExtent( width, height );
    }

    /**
     * Field implementation.
     * @see net.rim.device.api.ui.Field#paint(Graphics)
     */
    protected void paint(Graphics graphics) 
    {
        int textX, textY, textWidth, textHeight;
        int w = getWidth();
        int h = getHeight();
        
        switch(_shape) 
        {
            case TRIANGLE:
                h = (w>>1);
                int m = (w>>1)-1;
                
                graphics.drawLine(0, h-1, m, 0);
                graphics.drawLine(m, 0, w-1, h-1);
                graphics.drawLine(0, h-1, w-1, h-1);

                textWidth = Math.min(_labelWidth,h);
                textX = (w - textWidth) >> 1;
                textY = h >> 1;
                break;
                
            case TRIANGLE_DOWN:
                h = (w>>1);
                int m2 = (w>>1)-1;
                
                graphics.drawLine(0, 0, m2, h-1);
                graphics.drawLine(m2, h-1, w-1, 0);
                graphics.drawLine(0, 0, w-1, 0);

                textWidth = Math.min(_labelWidth,h);
                textX = (w - textWidth) >> 1;
                textY = 1;
                break;
                
            case TRIANGLE_LEFT:
                h = (w>>1);
                int m3 = (h>>1)-1;
                
                graphics.drawLine(w-1, 0, 0, m3);
                graphics.drawLine(0, m3, w-1, h-1);
                graphics.drawLine(w-1,h-1, w-1, 0);

                textHeight = Math.min(_labelHeight,w);
                textWidth = Math.min(_labelWidth,h);
                textX = 1;
                textY = (h-textHeight) >> 1;
                break;                

            case TRIANGLE_RIGHT:
                h = (w>>1);
                int m4 = (h>>1)-1;
                
                graphics.drawLine(0, 0, w-1, m4);
                graphics.drawLine(w-1, m4, 0, h-1);
                graphics.drawLine(0, h-1, 0, 0);

                textHeight = Math.min(_labelHeight,w);
                textWidth = Math.min(_labelWidth,h);
                textX = 1;
                textY = (h-textHeight) >> 1;
                break;                

            case OCTAGON:
                int x = 5*w/17;
                int x2 = w-x-1;
                int x3 = w-1;
                
                graphics.drawLine(0, x, 0, x2);
                graphics.drawLine(x3, x, x3, x2);
                graphics.drawLine(x, 0, x2, 0);
                graphics.drawLine(x, x3, x2, x3);
                graphics.drawLine(0, x, x, 0);
                graphics.drawLine(0, x2, x, x3);
                graphics.drawLine(x2, 0, x3, x);
                graphics.drawLine(x2, x3, x3, x2);

                textWidth = Math.min(_labelWidth, w - 6);
                textX = (w-textWidth) >> 1;
                textY = (w-_labelHeight) >> 1;
                break;

            case COLOUR_BACKGROUND:
                graphics.setColor(Color.LIGHTBLUE);
                graphics.fillRect(0, 0, w, h);
                graphics.setColor(Color.BLACK);
                
                textX = 4;
                textY = 2;
                textWidth = w - 6;
                break;
                
            default:
                graphics.drawRect(0, 0, w, h);

                textX = 4;
                textY = 2;
                textWidth = w - 6;
                break;
        }
        graphics.drawText(_label, textX, textY, (int)( getStyle() & DrawStyle.ELLIPSIS | DrawStyle.HALIGN_MASK ), textWidth );
    }
    
    /**
     * Overridden so that the Event Dispatch thread can catch this event
     * instead of having it be caught here.
     * @see net.rim.device.api.ui.Field#navigationClick(int, int)
     */
    protected boolean navigationClick(int status, int time) 
    {
        fieldChangeNotify(0);
        return true;
    }
    

}
