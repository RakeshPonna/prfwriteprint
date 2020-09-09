package com.rocky.prfwriteprint

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.print.PdfPrint
import android.print.PdfView
import android.print.PdfView.openPdfFile
import android.print.PrintAttributes
import android.print.PrintManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)

class MainActivity : AppCompatActivity() {
    var priceArray = arrayOf<String>("20", "30", "50", "60", "70", "80")
    var pronameArray = arrayOf<String>("200", "300", "500", "600", "700", "800")

    var hsnArray = arrayOf<String>("200", "300", "500", "600", "700", "800")

    var quantityArray = arrayOf<String>("2", "3", "5", "6", "7", "8")
    var igsttotArray = arrayOf<String>("200", "300", "500", "600", "700", "800")
    var cesstotalArray = arrayOf<String>("200", "300", "500", "600", "700", "800")


    private var myWebView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webview) as WebView

        val prr = findViewById<Button>(R.id.button) as Button


        var hh = "Value"
        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                return false
            }

            override fun onPageFinished(view: WebView, url: String) {
                /*createWebPrintJob(view)*/
                /*createWebPrintJob(view)*/
                myWebView = null
            }
        }

        var gros = 0.0F


        //Html document as 'String' value

        var htmlString = "<!DOCTYPE html>\n" +
                "<html\n" +
                "\txmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "\t<head>\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\"/>\n" +
                "\t\t<style>            table {border-collapse:collapse; table-layout:auto; width:210mm;}            table td {word-wrap:break-word;}            </style>\n" +
                "\t</head>\n" +
                "\t<body style=\"font-family:sans-serif,Helvetica, Monospace; font-size: 15px; margin: 0;\">\n" +
                "\t\t<table style=\"margin:auto;width: auto; font-size: 15px\">\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<table style=\" color: rgb(0, 0, 0);font-size:15px;width: 100%\">\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td style=\"vertical-align: top;\">\n" +
                "\t\t\t\t\t\t\t\t<table style = \"width: 100%\">\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left; font-weight: bold;font-size:15px;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left;padding-left: 5px;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<b>quickdine</b>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left;padding-left: 5px;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<b>quickdine</b>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left;padding-left: 5px;\">Phone No.: 911543115311</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left;padding-left: 5px;\">Email: anil.vadla@effiasoft.org</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t<td style=\"vertical-align: top;\">\n" +
                "\t\t\t\t\t\t\t\t<table style=\"width: 100%;\">\n" +
                "\t\t\t\t\t\t\t\t\t<tr></tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"text-align : right;font-weight : bold;font-size: 20px\">                                            ORDER                                        </td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t</table>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<table style=\"border-top: 2px solid black;border-collapse:collapse;width: 100%;\"  >\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td style=\"vertical-align: top;padding-top: 5px;\">\n" +
                "\t\t\t\t\t\t\t\t<table>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<b>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<b>NB General Stores.</b>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</b>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left;\">Address: Telang\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<br>ana,Hyderabad,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left;\">Phone No.: 8096645366</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t<table style=\"width: 200%;border-spacing: 0;border-collapse: collapse;\"                                    align=\"right\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align:right;font-size: 15px;font-weight:bold;color: #000000;\">                                            Order No.: ORD/B1/21/20                                        </td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;font-size: 15px;font-weight:bold;color: #000000;\">                                            Order Date: 31-Aug-2020 03:06 pm                                        </td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;font-size: 15px;color: #000000;\">                                            Type: Take Away                                        </td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: right; font-size: 15px;font-weight:bold;color: #000000;\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: right; font-size: 15px;font-weight:bold;color: #000000;\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: right; font-size: 15px;font-weight:bold;color: #000000;\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: right; font-size: 15px;font-weight:bold;color: #000000;\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t<table style=\"width: 100%;;margin-top: 10px;border-spacing: 0;border-collapse: collapse;border-top:2px solid #000000;border-bottom:2px solid #000000;\">\n" +
                "\t\t\t\t\t\t\t<tr style=\"background-color: #f1f1f1; height: 20px;\">\n" +
                "\t\t\t\t\t\t\t\t<td style=\"font-size: 10px; font-weight: bold; padding-left: 5px;\">                                Product/Service                            </td>\n" +
                "\t\t\t\t\t\t\t\t<td style=\"text-align: right; font-size: 10px; font-weight: bold; padding-right: 5px;\">                                Quantity                            </td>\n" +
                "\t\t\t\t\t\t\t\t<td style=\"text-align: center; font-size: 10px; font-weight: bold; padding-left: 5px;\">                                Unit Price                            </td>\n" +
                "\t\t\t\t\t\t\t\t<td style=\"text-align: center; font-size: 10px; font-weight: bold; padding-left: 5px;\">                                Discount                            </td>\n" +
                "\t\t\t\t\t\t\t\t<td style=\"text-align: right; font-size: 10px; font-weight: bold; padding-right: 5px;\">                                Tax 1                            </td>\n" +
                "\t\t\t\t\t\t\t\t<td style=\"text-align: right; font-size: 10px; font-weight: bold; padding-right: 5px;\">                                Tax 2                            </td>\n" +
                "\t\t\t\t\t\t\t\t<td style=\"text-align: right; font-size: 10px; font-weight: bold; padding-right: 5px;\">                                Tax 3                            </td>\n" +
                "\t\t\t\t\t\t\t\t<td style=\"text-align: right; font-size: 10px; font-weight: bold; padding-right: 5px;\">                                Amount                            </td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: left;padding-left: 5px;font-size: 10px\" valign=\"top\">Apple Juice</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;padding-left: 5px;font-size: 10px\" valign=\"top\">1 Each</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: center;padding-left: 5px;font-size: 10px\" valign=\"top\">₹100.00</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: center;padding-left: 5px;font-size: 10px\" valign=\"top\">₹0.00</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;padding-left: 5px;font-size: 10px\" valign=\"top\">₹0.00</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;padding-left: 5px;font-size: 10px\" valign=\"top\">₹0.00</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;padding-left: 5px;font-size: 10px\" valign=\"top\">₹0.00</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;padding-left: 5px;font-size: 10px\" valign=\"top\">₹100.00</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: left;padding-left: 5px;font-size: 10px\" valign=\"top\">Avocado Salad</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;padding-left: 5px;font-size: 10px\" valign=\"top\">1 Each</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: center;padding-left: 5px;font-size: 10px\" valign=\"top\">₹8.00</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: center;padding-left: 5px;font-size: 10px\" valign=\"top\">₹0.00</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;padding-left: 5px;font-size: 10px\" valign=\"top\">₹0.00</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;padding-left: 5px;font-size: 10px\" valign=\"top\">₹0.00</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;padding-left: 5px;font-size: 10px\" valign=\"top\">₹0.00</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;padding-left: 5px;font-size: 10px\" valign=\"top\">₹8.00</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t<table style=\"width: 100%\" >\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td style=\"vertical-align:top\">\n" +
                "\t\t\t\t\t\t\t\t\t<table style=\"font-size: 16px;width: 100%;\" align=\"left\" valign=\"top\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr style=\"text-align: left\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>Total No. of Products/Services</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>2</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr style=\"text-align: left\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>Total Quantity</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>2</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left;font-size: 16px;font-weight: bold;\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td colspan = \"2\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<br>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<table style=\"border-spacing: 0;margin-top: 5px;border-collapse: collapse;font-size: 16px;width: 100%;\" align=\"right\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr style=\"width:100%\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left; font-weight: bold;\">Sub Total :</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;\">₹108.00</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr style=\"width:100%\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left; font-weight: bold;\">Discount on Total :</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;\">-₹10.80</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"border-top: 1px solid #000000; border-top-width: 100%\" colspan=\"2\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left; font-weight: bold;font-size: 16px;\">                                            Grand Total:                                        </td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: right;font-size: 16px;\">₹97.20</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\" style=\"text-align: right\">                                            Ninety Seven Rupees  and Twenty Paisa Only                                        </td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<b></b>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: right\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<b></b>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: right\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<b></b>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t<table style=\"width:100%\">\n" +
                "\t\t\t\t\t\t\t\t\t<tr style=\"width:100%\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<td colspan=\"1\" align=\"left\"                                    style=\"border-top-width: 5px;border-top: solid black 2px;font-weight: normal;font-size: 16px;\"                                    valign=\"top\">                                    Powered by QJust Billing                                </td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td colspan=\"1\" align=\"right\"                                    style=\"border-top-width: 5px;border-top: solid black 2px;font-weight: normal;font-size: 16px;\">                                     31-Aug-2020 03:06 pm \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<br> | E &amp; O E                                \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t<tr align=\"right\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<td align=\"right\" style=\"width:100%;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<img src=\"@QRCode@\" width=\"100px\" style=\"float:right;\"/>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t</table>\n" +
                "\t\t\t\t</body>\n" +
                "\t\t\t</html>"

        var htmlDocument = "<html><body><h4>" + "Stock Details</h4>" +

                "<table class=Border>" +

                //S.No and Date inside non border table
                "<tr>" +
                "<td class=Border>S.No:</td>" +
                "<td class=Border>1</td>" + "</tr>" +
                "<tr>" +
                "<td class=Border>Date:</td>" +
                "<td class=Border>31/10/2018</td>" +
                "</tr>" +


                "<style>" +

                //Styles for border,header,table data
                "table, th, td {" +
                "border: 1px solid black;" +
                "border-collapse: collapse;" +
                "}" +


                //Padding for table header,table data
                "th, td {" +
                "padding: 15px;" +
                "}" +

                "td.Border {" +
                "border:none;" +
                "width:60%;" +
                "padding:8px;" +
                "}" +

                "table.Border {" +
                "border:none;" +
                "}" +


                //Align style for table header
                "th {" +
                "text-align: left;" +
                "}" +

                "</style>" +

                // Initaiate table width=100%
                "<table style=\"width:100%\">" +

                //Table Headers 'Price','Quantity','Total'
                "<tr>" +
                "<th>Price</th>" +
                "<th>Quantity</th>" +
                "<th>Total</th>" +
                "</tr>"

        for (i in 0 until priceArray.size) {

            //Calculate price and quantity
            var pri = priceArray[i].toFloat()
            var quan = quantityArray[i].toFloat()

            //Here is the total 'grtt'
            var gttt = (pri * quan)


            //Displaying array values in a table cells
            htmlDocument = htmlDocument +

                    "<tr>" +
                    "<td>${priceArray[i]}</td>" +
                    "<td>${quantityArray[i]}</td>" +
                    "<td>$gttt</td>" +
                    "</tr>"

            if (priceArray.size == i) {

            }

        }

        //Closing tag of html
        htmlDocument = htmlDocument +
                "</body></html>"

        //Load our html data
        webView.loadDataWithBaseURL(null, htmlString, "text/HTML", "UTF-8", null)
        myWebView = webView


        button.setOnClickListener {
            val path =
                Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "Stock Transfer"
            val fileName = "Test.pdf"
            val dir = File(path);
            if (!dir.exists())
                dir.mkdirs()


            val file = File(dir, fileName)
            val progressDialog = ProgressDialog(this@MainActivity)
            progressDialog.setMessage("Please wait")
            progressDialog.show()
            PdfView.createWebPdfJob(
                this@MainActivity,
                webView,
                file,
                fileName,
                object : PdfView.Callback {

                    override fun success(path: String) {
                        progressDialog.dismiss()
                        val builder = AlertDialog.Builder(this@MainActivity)
                        with(builder) {
                            setTitle("File Exported")
                            setMessage("Do you want to open a file?")
                            setPositiveButton("Open") { dialog, whichButton ->
                                openPdfFile(this@MainActivity, path)
                                //sendMail(path)
                            }
                            setNegativeButton("Cancel") { dialog, whichButton ->
                                //showMessage("Close the game or anything!")
                                dialog.dismiss()
                            }

                            // Dialog
                            val dialog = builder.create()

                            dialog.show()
                        }
                    }

                    override fun failure() {
                        progressDialog.dismiss()

                    }
                })
        }


    }

    fun sendMail(path: String) {  //Send this pdf to desired path.
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.putExtra(
            android.content.Intent.EXTRA_EMAIL,
            arrayOf("your E-mail addresses")
        )
        emailIntent.putExtra(
            android.content.Intent.EXTRA_SUBJECT,
            "Your subject"
        )
        emailIntent.putExtra(
            android.content.Intent.EXTRA_TEXT,
            "This is an autogenerated mail"
        )
        val file = File(path)
        val uri = FileProvider.getUriForFile(
            this@MainActivity,
            BuildConfig.APPLICATION_ID + "fileproviders",
            file
        )
        emailIntent.type = "application/pdf"
        emailIntent.putExtra(Intent.EXTRA_STREAM, uri)

        startActivity(Intent.createChooser(emailIntent, "Send mail..."))
        finish()
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun createWebPrintJob1(webView: WebView) {

        val printManager = this
            .getSystemService(Context.PRINT_SERVICE) as PrintManager

        val printAdapter = webView.createPrintDocumentAdapter("MyDocument")

        val jobName = getString(R.string.app_name) + " Print Test"

        printManager.print(
            jobName, printAdapter,
            PrintAttributes.Builder().build()
        )
    }


    private fun createWebPrintJob2(webView: WebView) {
        val jobName = getString(R.string.app_name) + " Document"
        val attributes = PrintAttributes.Builder()
            .setMediaSize(PrintAttributes.MediaSize.ISO_A4)
            .setResolution(PrintAttributes.Resolution("pdf", "pdf", 600, 600))
            .setMinMargins(PrintAttributes.Margins.NO_MARGINS).build()
        val path =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + "/PDFTest/")
        val pdfPrint = PdfPrint(attributes)

        pdfPrint.print(
            webView.createPrintDocumentAdapter(jobName),
            path,
            "output_" + System.currentTimeMillis() + ".pdf",
            object : PdfPrint.CallbackPrint {
                override fun success(path: String) {
                    TODO("Not yet implemented")
                }

                override fun onFailure() {
                    TODO("Not yet implemented")
                }

            })
    }

   /* @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun createWebPrintJob(webView: WebView) {

        val printManager = this
            .getSystemService(Context.PRINT_SERVICE) as PrintManager

        val printAdapter = webView.createPrintDocumentAdapter("MyDocument")

        val jobName = getString(R.string.app_name) + " Print Test"

        PrintAttributes attributes = new PrintAttributes.Builder()
        printManager.print(
            jobName, printAdapter,
            PrintAttributes.Builder()
                .setMediaSize(PrintAttributes.MediaSize.ISO_A4)
                .setResolution(new PrintAttributes . Resolution ("pdf", "pdf", 600, 600)
        )
            .setMinMargins(PrintAttributes.Margins.NO_MARGINS).build())
    }*/
}
