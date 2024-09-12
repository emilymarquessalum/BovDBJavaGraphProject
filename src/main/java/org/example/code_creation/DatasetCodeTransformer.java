package org.example.code_creation;

import java.util.ArrayList;

public class DatasetCodeTransformer {
    String startDate;
    String endDate;
    public DatasetCodeTransformer(String startDate,
    String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTransformedCode() {
        String filterString = "";

        if(startDate.isEmpty() == false) {
            filterString += "df = df.loc[df['" + "date" + "'] " + "&gt;=" + " '"+  startDate + "']<br>";
        }
        if(endDate.isEmpty() == false) {
            filterString += "df = df.loc[df['" + "date" + "'] " + "&lt;=" + " '" + endDate + "']<br>";
        }


        String transformedCode = "<br>" +
                "" +
                "import sqlite3<br>" +
                "from pandas import DataFrame<br>" +
                "import pandas as pd<br>" +
                "import numpy as np<br>" +
                "import math<br>" +
                "import matplotlib.pyplot as plt<br>" +
                "import matplotlib.dates as mpl_dates<br>" +
                "from mpl_finance import candlestick_ohlc<br>" +
                "<br> " +
                "#____________________________________Accessing the BovDB database and collecting data_______________________________________________<br>" +
                "conn = sqlite3.connect('../DataBase/DataBase.db')<br>" +
                "cursor = conn.cursor()<br>" +
                "<br>" +
                "cursor.execute(\"\"\"SELECT c.id_ticker, c.date, c.open, c.high, c.low, c.close, c.factor<br>" +
                "                                           FROM price as c JOIN ticker as p on c.id_ticker = p.id_ticker WHERE p.id_ticker = 107\"\"\")<br>" +
                "df = DataFrame(cursor.fetchall())<br>" +
                "conn.close()<br>" +
                "<br>" +
                "df.columns = [\"cd_ticker\", \"date\", \"open\", \"high\", \"low\", \"close\", \"factor\"]" +
                "<br>" +
                filterString +
                "<br>" +
                "def daily_candlesitcks_chart(df):<br>" +
                "    BovDB_datas = df.loc[:, [\"date\", \"open\", \"high\", \"low\", \"close\"]]<br>" +
                "    BovDB_datas['date'] = pd.to_datetime(BovDB_datas['date'])<br>" +
                "    BovDB_datas['date'] = BovDB_datas['date'].apply(mpl_dates.date2num)<br>" +
                "    BovDB_datas = BovDB_datas.astype(float)<br>" +
                "<br>" +
                "    # Creating Subplots<br>" +
                "    plt.rcParams[\"figure.figsize\"] = (7, 6)<br>" +
                "    fig, ax = plt.subplots()<br>" +
                "    plt.yticks((20.55, 30.00, 40.00, 50.00, 70.00, 90.00, 110.00,120.00, 130.00))<br>" +
                "    candlestick_ohlc(ax, BovDB_datas.values, width=0.6, colorup='green', colordown='red', alpha=1)<br>" +
                "<br>" +
                "    # Setting labels & titles<br>" +
                "    ax.set_xlabel('Date',fontsize=22, fontfamily='serif')<br>" +
                "    ax.set_ylabel('Price (R$)',fontsize=22, fontfamily='serif')<br>" +
                "    ax.set_title('PETR4 (without factor)', fontsize=23, fontstyle= 'italic', fontfamily='serif')<br>" +
                "    plt.xticks(rotation=45)<br>" +
                "    plt.xticks(size=20)<br>" +
                "    plt.yticks(size=20)<br>" +
                "<br>" +
                "    # tormatting Date<br>" +
                "    date_format = mpl_dates.DateFormatter('%Y-%m-%d')<br>" +
                "    ax.xaxis.set_major_formatter(date_format)<br>" +
                "    fig.autofmt_xdate()<br>" +
                "<br>" +
                "    fig.tight_layout()<br>" +
                "    plt.savefig('daily_candlesitcks_chart.pdf', format='pdf')<br>" +
                "    plt.show()" +
                "" +
                "<br>" +
                "daily_candlesitcks_chart(df)";



        return transformedCode;
    }
}
