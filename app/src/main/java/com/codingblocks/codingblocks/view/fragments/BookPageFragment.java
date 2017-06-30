package com.codingblocks.codingblocks.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.codingblocks.R;

import im.delight.android.webview.AdvancedWebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookPageFragment extends Fragment {



    AdvancedWebView webView;
    public static final String TAG = "BookPageFragment";
    public BookPageFragment() {
        // Required empty public constructor
    }

    public static BookPageFragment getInstance(String data){
        BookPageFragment  bookPageFragment = new BookPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("data",data);
        bookPageFragment.setArguments(bundle);
        return bookPageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book_page, container, false);
         webView = (AdvancedWebView) root.findViewById(R.id.webview);
        String thisData = getArguments().getString("data");
        Log.d(TAG, "onCreateView: " + thisData);
        setData(thisData);


        return root;
    }


    public void setData(String data){
        String text = "<html><style>" +
                "body {" +
                "   margin: 0; padding: 0px" +
                "}" +
                ".gb {" +
                "    background: #f6f6f6; padding: 10px" +
                "}" +
                ".ms {\n" +
                "    display: block;\n" +
                "    word-wrap: break-word;\n" +
                "    overflow: hidden;\n" +
                "    color: #333;\n" +
                "    line-height: 1.7;\n" +
                "    text-size-adjust: 100%;\n" +
                "    -ms-text-size-adjust: 100%;\n" +
                "    -webkit-text-size-adjust: 100%;\n" +
                "    -moz-text-size-adjust: 100%;\n" +
                "}" +
                "xq.nm a {" +
                "    color: #4183c4" +
                "}" +
                ".ms pre {\n" +
                "    overflow: auto;\n" +
                "    word-wrap: normal;\n" +
                "    margin: 0;\n" +
                "    padding: .85em 1em;\n" +
                "    margin-bottom: 1.275em;\n" +
                "    background: #e5e5e5;\n" +
                "}" +
                ".ms table {\n" +
                "    display: table;\n" +
                "    width: 100%;\n" +
                "    border-collapse: collapse;\n" +
                "    border-spacing: 0;\n" +
                "    overflow: auto;\n" +
                "}" +
                ".ms table tr {\n" +
                "    background-color: #eee;\n" +
                "    border-top: 1px solid #ccc;\n" +
                "}" +
                ".ms table tr:nth-child(2n) {\n" +
                "    background-color: #e8e8e8;\n" +
                "}" +
                ".ms table td, .ms table th {\n" +
                "    padding: 6px 13px;\n" +
                "    border: 1px solid #ddd;\n" +
                "}" +
                ".ms table th {\n" +
                "    font-weight: 700;\n" +
                "}" +

//                =============== THEME STUFF =============
                ".ct2 .dropdown-menu {\n" +
                "  background-color: #2d3143;\n" +
                "  border-color: #272a3a;\n" +
                "}\n" +
                ".ct2 .dropdown-menu .dropdown-caret .caret-inner {\n" +
                "  border-bottom: 9px solid #2d3143;\n" +
                "}\n" +
                ".ct2 .dropdown-menu .buttons {\n" +
                "  border-color: #272a3a;\n" +
                "}\n" +
                ".ct2 .dropdown-menu .button {\n" +
                "  color: #62677f;\n" +
                "}\n" +
                ".ct2 .dropdown-menu .button:hover {\n" +
                "  color: #f4f4f5;\n" +
                "}\n" +
                ".gb.ct2 {\n" +
                "  color: #bdcadb;\n" +
                "  background: #1c1f2b;\n" +
                "}\n" +
                ".gb.ct2 .book-body {\n" +
                "  color: #bdcadb;\n" +
                "  background: #1c1f2b;\n" +
                "}\n" +
                ".gb.ct2  xq {\n" +
                "  background: #1c1f2b;\n" +
                "}\n" +
                ".gb.font-size-0 .book-body .page-inner xq {\n" +
                "  font-size: 1.2rem;\n" +
                "}\n" +
                ".gb.font-size-1 .book-body .page-inner xq {\n" +
                "  font-size: 1.4rem;\n" +
                "}\n" +
                ".gb.font-size-2 .book-body .page-inner xq {\n" +
                "  font-size: 1.6rem;\n" +
                "}\n" +
                ".gb.font-size-3 .book-body .page-inner xq {\n" +
                "  font-size: 2.2rem;\n" +
                "}\n" +
                ".gb.font-size-4 .book-body .page-inner xq {\n" +
                "  font-size: 4rem;\n" +
                "}\n" +
                ".gb.font-family-0 {\n" +
                "  font-family: Georgia, serif;\n" +
                "}\n" +
                ".gb.font-family-1 {\n" +
                "  font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serif;\n" +
                "}\n" +

                ".gb.ct2  xq.nm {\n" +
                "  color: #bdcadb;\n" +
                "}\n" +
                ".gb.ct2  xq.nm a {\n" +
                "  color: #3eb1d0;\n" +
                "}\n" +
                ".gb.ct2  xq.nm h1,\n" +
                ".gb.ct2  xq.nm h2,\n" +
                ".gb.ct2  xq.nm h3,\n" +
                ".gb.ct2  xq.nm h4,\n" +
                ".gb.ct2  xq.nm h5,\n" +
                ".gb.ct2  xq.nm h6 {\n" +
                "  color: #fffffa;\n" +
                "}\n" +
                ".gb.ct2  xq.nm h1,\n" +
                ".gb.ct2  xq.nm h2 {\n" +
                "  border-color: #373b4e;\n" +
                "}\n" +
                ".gb.ct2  xq.nm h6 {\n" +
                "  color: #373b4e;\n" +
                "}\n" +
                ".gb.ct2  xq.nm hr {\n" +
                "  background-color: #373b4e;\n" +
                "}\n" +
                ".gb.ct2  xq.nm blockquote {\n" +
                "  border-color: #373b4e;\n" +
                "}\n" +
                ".gb.ct2  xq.nm pre,\n" +
                ".gb.ct2  xq.nm code {\n" +
                "  color: #9dbed8;\n" +
                "  background: #2d3143;\n" +
                "  border-color: #2d3143;\n" +
                "}\n" +
                ".gb.ct2  xq.nm .highlight {\n" +
                "  background-color: #282a39;\n" +
                "}\n" +
                ".gb.ct2  xq.nm table th,\n" +
                ".gb.ct2  xq.nm table td {\n" +
                "  border-color: #3b3f54;\n" +
                "}\n" +
                ".gb.ct2  xq.nm table tr {\n" +
                "  color: #b6c2d2;\n" +
                "  background-color: #2d3143;\n" +
                "  border-color: #3b3f54;\n" +
                "}\n" +
                ".gb.ct2  xq.nm table tr:nth-child(2n) {\n" +
                "  background-color: #35394b;\n" +
                "}\n" +


                ".gb.ct2 .book-body .navigation {\n" +
                "  color: #383f52;\n" +
                "}\n" +
                ".gb.ct2 .book-body .navigation:hover {\n" +
                "  color: #fffff5;\n" +
                "}\n" +
                //                ============== HLJS STUFF ===============
                "\n" +
                ".gb  xq.nm pre .hljs-comment,\n" +
                ".gb  xq.nm code .hljs-comment,\n" +
                ".gb  xq.nm pre .hljs-title,\n" +
                ".gb  xq.nm code .hljs-title {\n" +
                "  color: #8e908c;\n" +
                "}\n" +
                ".gb  xq.nm pre .hljs-variable,\n" +
                ".gb  xq.nm code .hljs-variable,\n" +
                ".gb  xq.nm pre .hljs-attribute,\n" +
                ".gb  xq.nm code .hljs-attribute,\n" +
                ".gb  xq.nm pre .hljs-tag,\n" +
                ".gb  xq.nm code .hljs-tag,\n" +
                ".gb  xq.nm pre .hljs-regexp,\n" +
                ".gb  xq.nm code .hljs-regexp,\n" +
                ".gb  xq.nm pre .hljs-deletion,\n" +
                ".gb  xq.nm code .hljs-deletion,\n" +
                ".gb  xq.nm pre .ruby .hljs-constant,\n" +
                ".gb  xq.nm code .ruby .hljs-constant,\n" +
                ".gb  xq.nm pre .xml .hljs-tag .hljs-title,\n" +
                ".gb  xq.nm code .xml .hljs-tag .hljs-title,\n" +
                ".gb  xq.nm pre .xml .hljs-pi,\n" +
                ".gb  xq.nm code .xml .hljs-pi,\n" +
                ".gb  xq.nm pre .xml .hljs-doctype,\n" +
                ".gb  xq.nm code .xml .hljs-doctype,\n" +
                ".gb  xq.nm pre .html .hljs-doctype,\n" +
                ".gb  xq.nm code .html .hljs-doctype,\n" +
                ".gb  xq.nm pre .css .hljs-id,\n" +
                ".gb  xq.nm code .css .hljs-id,\n" +
                ".gb  xq.nm pre .css .hljs-class,\n" +
                ".gb  xq.nm code .css .hljs-class,\n" +
                ".gb  xq.nm pre .css .hljs-pseudo,\n" +
                ".gb  xq.nm code .css .hljs-pseudo {\n" +
                "  color: #c82829;\n" +
                "}\n" +
                ".gb  xq.nm pre .hljs-number,\n" +
                ".gb  xq.nm code .hljs-number,\n" +
                ".gb  xq.nm pre .hljs-preprocessor,\n" +
                ".gb  xq.nm code .hljs-preprocessor,\n" +
                ".gb  xq.nm pre .hljs-pragma,\n" +
                ".gb  xq.nm code .hljs-pragma,\n" +
                ".gb  xq.nm pre .hljs-built_in,\n" +
                ".gb  xq.nm code .hljs-built_in,\n" +
                ".gb  xq.nm pre .hljs-literal,\n" +
                ".gb  xq.nm code .hljs-literal,\n" +
                ".gb  xq.nm pre .hljs-params,\n" +
                ".gb  xq.nm code .hljs-params,\n" +
                ".gb  xq.nm pre .hljs-constant,\n" +
                ".gb  xq.nm code .hljs-constant {\n" +
                "  color: #f5871f;\n" +
                "}\n" +
                ".gb  xq.nm pre .ruby .hljs-class .hljs-title,\n" +
                ".gb  xq.nm code .ruby .hljs-class .hljs-title,\n" +
                ".gb  xq.nm pre .css .hljs-rules .hljs-attribute,\n" +
                ".gb  xq.nm code .css .hljs-rules .hljs-attribute {\n" +
                "  color: #eab700;\n" +
                "}\n" +
                ".gb  xq.nm pre .hljs-string,\n" +
                ".gb  xq.nm code .hljs-string,\n" +
                ".gb  xq.nm pre .hljs-value,\n" +
                ".gb  xq.nm code .hljs-value,\n" +
                ".gb  xq.nm pre .hljs-inheritance,\n" +
                ".gb  xq.nm code .hljs-inheritance,\n" +
                ".gb  xq.nm pre .hljs-header,\n" +
                ".gb  xq.nm code .hljs-header,\n" +
                ".gb  xq.nm pre .hljs-addition,\n" +
                ".gb  xq.nm code .hljs-addition,\n" +
                ".gb  xq.nm pre .ruby .hljs-symbol,\n" +
                ".gb  xq.nm code .ruby .hljs-symbol,\n" +
                ".gb  xq.nm pre .xml .hljs-cdata,\n" +
                ".gb  xq.nm code .xml .hljs-cdata {\n" +
                "  color: #718c00;\n" +
                "}\n" +
                ".gb  xq.nm pre .css .hljs-hexcolor,\n" +
                ".gb  xq.nm code .css .hljs-hexcolor {\n" +
                "  color: #3e999f;\n" +
                "}\n" +
                ".gb  xq.nm pre .hljs-function,\n" +
                ".gb  xq.nm code .hljs-function,\n" +
                ".gb  xq.nm pre .python .hljs-decorator,\n" +
                ".gb  xq.nm code .python .hljs-decorator,\n" +
                ".gb  xq.nm pre .python .hljs-title,\n" +
                ".gb  xq.nm code .python .hljs-title,\n" +
                ".gb  xq.nm pre .ruby .hljs-function .hljs-title,\n" +
                ".gb  xq.nm code .ruby .hljs-function .hljs-title,\n" +
                ".gb  xq.nm pre .ruby .hljs-title .hljs-keyword,\n" +
                ".gb  xq.nm code .ruby .hljs-title .hljs-keyword,\n" +
                ".gb  xq.nm pre .perl .hljs-sub,\n" +
                ".gb  xq.nm code .perl .hljs-sub,\n" +
                ".gb  xq.nm pre .javascript .hljs-title,\n" +
                ".gb  xq.nm code .javascript .hljs-title,\n" +
                ".gb  xq.nm pre .coffeescript .hljs-title,\n" +
                ".gb  xq.nm code .coffeescript .hljs-title {\n" +
                "  color: #4271ae;\n" +
                "}\n" +
                ".gb  xq.nm pre .hljs-keyword,\n" +
                ".gb  xq.nm code .hljs-keyword,\n" +
                ".gb  xq.nm pre .javascript .hljs-function,\n" +
                ".gb  xq.nm code .javascript .hljs-function {\n" +
                "  color: #8959a8;\n" +
                "}\n" +
                ".gb  xq.nm pre .hljs,\n" +
                ".gb  xq.nm code .hljs {\n" +
                "  display: block;\n" +
                "  background: white;\n" +
                "  color: #4d4d4c;\n" +
                "  padding: 0.5em;\n" +
                "}\n" +
                ".gb  xq.nm pre .coffeescript .javascript,\n" +
                ".gb  xq.nm code .coffeescript .javascript,\n" +
                ".gb  xq.nm pre .javascript .xml,\n" +
                ".gb  xq.nm code .javascript .xml,\n" +
                ".gb  xq.nm pre .tex .hljs-formula,\n" +
                ".gb  xq.nm code .tex .hljs-formula,\n" +
                ".gb  xq.nm pre .xml .javascript,\n" +
                ".gb  xq.nm code .xml .javascript,\n" +
                ".gb  xq.nm pre .xml .vbscript,\n" +
                ".gb  xq.nm code .xml .vbscript,\n" +
                ".gb  xq.nm pre .xml .css,\n" +
                ".gb  xq.nm code .xml .css,\n" +
                ".gb  xq.nm pre .xml .hljs-cdata,\n" +
                ".gb  xq.nm code .xml .hljs-cdata {\n" +
                "  opacity: 0.5;\n" +
                "}\n" +
                ".gb.ct2  xq.nm pre .hljs-comment,\n" +
                ".gb.ct2  xq.nm code .hljs-comment,\n" +
                ".gb.ct2  xq.nm pre .hljs-title,\n" +
                ".gb.ct2  xq.nm code .hljs-title {\n" +
                "  color: #969896;\n" +
                "}\n" +
                ".gb.ct2  xq.nm pre .hljs-variable,\n" +
                ".gb.ct2  xq.nm code .hljs-variable,\n" +
                ".gb.ct2  xq.nm pre .hljs-attribute,\n" +
                ".gb.ct2  xq.nm code .hljs-attribute,\n" +
                ".gb.ct2  xq.nm pre .hljs-tag,\n" +
                ".gb.ct2  xq.nm code .hljs-tag,\n" +
                ".gb.ct2  xq.nm pre .hljs-regexp,\n" +
                ".gb.ct2  xq.nm code .hljs-regexp,\n" +
                ".gb.ct2  xq.nm pre .hljs-deletion,\n" +
                ".gb.ct2  xq.nm code .hljs-deletion,\n" +
                ".gb.ct2  xq.nm pre .ruby .hljs-constant,\n" +
                ".gb.ct2  xq.nm code .ruby .hljs-constant,\n" +
                ".gb.ct2  xq.nm pre .xml .hljs-tag .hljs-title,\n" +
                ".gb.ct2  xq.nm code .xml .hljs-tag .hljs-title,\n" +
                ".gb.ct2  xq.nm pre .xml .hljs-pi,\n" +
                ".gb.ct2  xq.nm code .xml .hljs-pi,\n" +
                ".gb.ct2  xq.nm pre .xml .hljs-doctype,\n" +
                ".gb.ct2  xq.nm code .xml .hljs-doctype,\n" +
                ".gb.ct2  xq.nm pre .html .hljs-doctype,\n" +
                ".gb.ct2  xq.nm code .html .hljs-doctype,\n" +
                ".gb.ct2  xq.nm pre .css .hljs-id,\n" +
                ".gb.ct2  xq.nm code .css .hljs-id,\n" +
                ".gb.ct2  xq.nm pre .css .hljs-class,\n" +
                ".gb.ct2  xq.nm code .css .hljs-class,\n" +
                ".gb.ct2  xq.nm pre .css .hljs-pseudo,\n" +
                ".gb.ct2  xq.nm code .css .hljs-pseudo {\n" +
                "  color: #d54e53;\n" +
                "}\n" +
                ".gb.ct2  xq.nm pre .hljs-number,\n" +
                ".gb.ct2  xq.nm code .hljs-number,\n" +
                ".gb.ct2  xq.nm pre .hljs-preprocessor,\n" +
                ".gb.ct2  xq.nm code .hljs-preprocessor,\n" +
                ".gb.ct2  xq.nm pre .hljs-pragma,\n" +
                ".gb.ct2  xq.nm code .hljs-pragma,\n" +
                ".gb.ct2  xq.nm pre .hljs-built_in,\n" +
                ".gb.ct2  xq.nm code .hljs-built_in,\n" +
                ".gb.ct2  xq.nm pre .hljs-literal,\n" +
                ".gb.ct2  xq.nm code .hljs-literal,\n" +
                ".gb.ct2  xq.nm pre .hljs-params,\n" +
                ".gb.ct2  xq.nm code .hljs-params,\n" +
                ".gb.ct2  xq.nm pre .hljs-constant,\n" +
                ".gb.ct2  xq.nm code .hljs-constant {\n" +
                "  color: #e78c45;\n" +
                "}\n" +
                ".gb.ct2  xq.nm pre .ruby .hljs-class .hljs-title,\n" +
                ".gb.ct2  xq.nm code .ruby .hljs-class .hljs-title,\n" +
                ".gb.ct2  xq.nm pre .css .hljs-rules .hljs-attribute,\n" +
                ".gb.ct2  xq.nm code .css .hljs-rules .hljs-attribute {\n" +
                "  color: #e7c547;\n" +
                "}\n" +
                ".gb.ct2  xq.nm pre .hljs-string,\n" +
                ".gb.ct2  xq.nm code .hljs-string,\n" +
                ".gb.ct2  xq.nm pre .hljs-value,\n" +
                ".gb.ct2  xq.nm code .hljs-value,\n" +
                ".gb.ct2  xq.nm pre .hljs-inheritance,\n" +
                ".gb.ct2  xq.nm code .hljs-inheritance,\n" +
                ".gb.ct2  xq.nm pre .hljs-header,\n" +
                ".gb.ct2  xq.nm code .hljs-header,\n" +
                ".gb.ct2  xq.nm pre .hljs-addition,\n" +
                ".gb.ct2  xq.nm code .hljs-addition,\n" +
                ".gb.ct2  xq.nm pre .ruby .hljs-symbol,\n" +
                ".gb.ct2  xq.nm code .ruby .hljs-symbol,\n" +
                ".gb.ct2  xq.nm pre .xml .hljs-cdata,\n" +
                ".gb.ct2  xq.nm code .xml .hljs-cdata {\n" +
                "  color: #b9ca4a;\n" +
                "}\n" +
                ".gb.ct2  xq.nm pre .css .hljs-hexcolor,\n" +
                ".gb.ct2  xq.nm code .css .hljs-hexcolor {\n" +
                "  color: #70c0b1;\n" +
                "}\n" +
                ".gb.ct2  xq.nm pre .hljs-function,\n" +
                ".gb.ct2  xq.nm code .hljs-function,\n" +
                ".gb.ct2  xq.nm pre .python .hljs-decorator,\n" +
                ".gb.ct2  xq.nm code .python .hljs-decorator,\n" +
                ".gb.ct2  xq.nm pre .python .hljs-title,\n" +
                ".gb.ct2  xq.nm code .python .hljs-title,\n" +
                ".gb.ct2  xq.nm pre .ruby .hljs-function .hljs-title,\n" +
                ".gb.ct2  xq.nm code .ruby .hljs-function .hljs-title,\n" +
                ".gb.ct2  xq.nm pre .ruby .hljs-title .hljs-keyword,\n" +
                ".gb.ct2  xq.nm code .ruby .hljs-title .hljs-keyword,\n" +
                ".gb.ct2  xq.nm pre .perl .hljs-sub,\n" +
                ".gb.ct2  xq.nm code .perl .hljs-sub,\n" +
                ".gb.ct2  xq.nm pre .javascript .hljs-title,\n" +
                ".gb.ct2  xq.nm code .javascript .hljs-title,\n" +
                ".gb.ct2  xq.nm pre .coffeescript .hljs-title,\n" +
                ".gb.ct2  xq.nm code .coffeescript .hljs-title {\n" +
                "  color: #7aa6da;\n" +
                "}\n" +
                ".gb.ct2  xq.nm pre .hljs-keyword,\n" +
                ".gb.ct2  xq.nm code .hljs-keyword,\n" +
                ".gb.ct2  xq.nm pre .javascript .hljs-function,\n" +
                ".gb.ct2  xq.nm code .javascript .hljs-function {\n" +
                "  color: #c397d8;\n" +
                "}\n" +
                ".gb.ct2  xq.nm pre .hljs,\n" +
                ".gb.ct2  xq.nm code .hljs {\n" +
                "  display: block;\n" +
                "  background: black;\n" +
                "  color: #eaeaea;\n" +
                "  padding: 0.5em;\n" +
                "}\n" +
                ".gb.ct2  xq.nm pre .coffeescript .javascript,\n" +
                ".gb.ct2  xq.nm code .coffeescript .javascript,\n" +
                ".gb.ct2  xq.nm pre .javascript .xml,\n" +
                ".gb.ct2  xq.nm code .javascript .xml,\n" +
                ".gb.ct2  xq.nm pre .tex .hljs-formula,\n" +
                ".gb.ct2  xq.nm code .tex .hljs-formula,\n" +
                ".gb.ct2  xq.nm pre .xml .javascript,\n" +
                ".gb.ct2  xq.nm code .xml .javascript,\n" +
                ".gb.ct2  xq.nm pre .xml .vbscript,\n" +
                ".gb.ct2  xq.nm code .xml .vbscript,\n" +
                ".gb.ct2  xq.nm pre .xml .css,\n" +
                ".gb.ct2  xq.nm code .xml .css,\n" +
                ".gb.ct2  xq.nm pre .xml .hljs-cdata,\n" +
                ".gb.ct2  xq.nm code .xml .hljs-cdata {\n" +
                "  opacity: 0.5;\n" +
                "}\n" +

                "</style><body>" +
                "<div class=\"gb without-animation with-summary font-size-2 font-family-1 ct2\">\n" +
                "                        <div class=\"search-noresults\">\n" +
                "                            <xq class=\"nm ms\">" +
                data +
                "                            </xq>\n" +
                "    </div>\n" +
                "</div></body></html>";
        webView.setCookiesEnabled(false);
        webView.setMixedContentAllowed(false);
        webView.setGeolocationEnabled(false);
        webView.getSettings().setJavaScriptEnabled(false);
        webView.getSettings().setDatabaseEnabled(false);
        webView.getSettings().setDomStorageEnabled(false);
        webView.getSettings().setAppCacheEnabled(false);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setDisplayZoomControls(false);

        webView.loadHtml(text);
    }


}
