import { Component, OnInit } from '@angular/core';
import { ChartType, ChartOptions, ChartDataSets } from 'chart.js';
import { Label, SingleDataSet, Color } from 'ng2-charts';
import { DataFromEndOfficeService } from '../service/data-from-end-office.service';
import { Subscriber } from '../subscriber/subscriber.component';
import { Subscription } from '../add-subscription/add-subscription.component';
import { Presence } from '../calendar-test/calendar-test.component';
import { CalendarDataService } from '../service/calendar-data.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-fusion-chart-test',
  templateUrl: './fusion-chart-test.component.html',
  styleUrls: ['./fusion-chart-test.component.css']
})
export class FusionChartTestComponent implements OnInit {

  subscribers: Subscriber[] = []

  numberUserReglo: number = 0
  numberUserNotReglo: number = 0
  subscription: Subscription[] = []
  presence: Presence[] = []

  subscription1: Subscription[] = []
  presence1: Presence[] = []

  pieChartOptions: ChartOptions = {
    responsive: true,
  };

  public pieChartLabels = ['Non réglo', 'réglo'];
  public pieChartData: SingleDataSet = [0, 0];
  public pieChartType: ChartType = 'pie';
  public pieChartLegend = true;
  public pieChartPlugins = [];

  public barChartOptions: ChartOptions = {
    responsive: true,
  };
  public barChartLabels: Label[] = ['Janvier', 'Fevrier', 'Mars', 'Avril', 'Mai', 'Juin',
    'Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Decembre'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [];

  public barChartData: ChartDataSets[] = [
    { data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], label: 'Montant gagné par mois (Dirham)' }
  ];

  public lineChartData: ChartDataSets[] = [
    { data: [0, 0, 0, 0, 0, 0, 0], label: 'Nombre de présence' },
  ];
  public lineChartLabels: Label[] = ['Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi', 'Dimanche'];
  public lineChartOptions: ChartOptions = {
    responsive: true,
  };
  public lineChartColors: Color[] = [
    {
      borderColor: 'black',
      backgroundColor: 'rgba(255,0,0,0.3)',
    },
  ];
  public lineChartLegend = true;
  public lineChartType = 'line';
  public lineChartPlugins = [];


  constructor(private dataFromEndOfficeService: DataFromEndOfficeService,
    private calendarDataService: CalendarDataService) {
  }


  ngOnInit() {
    let club = sessionStorage.getItem("idClub")
    this.fillPieChartData()
    this.filBarChartData(club, "2019")
    this.lineChart(club)

  }

  pieChartEvent(){
  console.log("unclick sur pieChart")
  } 

  lineChart(club) {
    let pipe = new DatePipe('en-US')
    let stringDateTest = "2019-07-22"
    let dateTest = new Date(stringDateTest)

    this.dataFromEndOfficeService.retrievePresencesByClub(club).subscribe(
      data => {
        let lun = 0, mar = 0, mer = 0, jeu = 0, ven = 0, sam = 0, dim = 0
        for (var i = 0; i < data.length; i++) {
          let event = data[i].datePresence
          let dayOfWekk = new Date(pipe.transform(event, "yyyy-MM-dd")).getDay()
          console.log("---------voici une date de la semaine----------- " + dayOfWekk)
          if (dayOfWekk === 1) {
            lun++
          } if (dayOfWekk === 2) {
            mar++
          } if (dayOfWekk === 3) {
            mer++
          } if (dayOfWekk === 4) {
            jeu++
          } if (dayOfWekk === 5) {
            ven++
          } if (dayOfWekk === 6) {
            sam++
          } if (dayOfWekk === 0) {
            dim++
          }
        }
        this.lineChartData = [
          { data: [lun, mar, mer, jeu, ven, sam, dim], label: 'Nombre de presence' },
        ];
      }
    )

  }

  fillPieChartData() {
    let club = sessionStorage.getItem('idClub')
    this.dataFromEndOfficeService.retrieveListSubscriber(club).subscribe(
      data => {
        this.subscribers = data
        this.searchByUser(this.subscribers)
      }
    )
  }

  searchByUser(subscribers) {
    for (var _i = 0; _i < subscribers.length; _i++) {
      this.subscription = null
      this.presence = null
      let subscribeId = subscribers[_i].idSub
      this.retriveSubscriptionsFirstLyAndPresenceSecondly(subscribeId)
    }
  }

  retriveSubscriptionsFirstLyAndPresenceSecondly(subscribeId) {
    this.calendarDataService.retrieveSubscriptionSub(subscribeId).subscribe(
      data => {
        this.subscription = data
        this.retrivePresences(subscribeId, data)
      }
    )
  }

  retrivePresences(subscribeId, subsUser) {
    this.calendarDataService.getPresencebyUser(subscribeId).subscribe(
      data => {
        this.presence = data
        let result = this.calendarDataService.checkIfUserIsReglo(subsUser, this.presence)
        if (result === true) {
          this.numberUserReglo++
        }
        if (result === false) {
          this.numberUserNotReglo++
        }
        this.pieChartData = [this.numberUserNotReglo, this.numberUserReglo];
      }
    )
  }

  filBarChartData(club, year) {
    let subsIdAndPriceSubs: string[] = []
    let monthAndIdSubscription: string[] = []
    let pipe = new DatePipe('en-US')

    this.dataFromEndOfficeService.retrievePerDaySubscription(club).subscribe(
      data => {
        for (var d = 0; d < data.length; d++) {
          subsIdAndPriceSubs.push(data[d].idTypeSubs + " " + data[d].pricePerDaySubscription)
        }
        this.dataFromEndOfficeService.retrievePerMonthSubscription(club).subscribe(
          data => {
            for (var m = 0; m < data.length; m++) {
              subsIdAndPriceSubs.push(data[m].idTypeSubs + " " + data[m].pricePerMonthSubscription)
            }
            this.dataFromEndOfficeService.retrievePerThreeMonthSubscription(club).subscribe(
              data => {
                for (var tm = 0; tm < data.length; tm++) {
                  subsIdAndPriceSubs.push(data[tm].idTypeSubs + " " + data[tm].pricePerThreeMonthSubscription)
                }
                this.dataFromEndOfficeService.retrievePerSixMonthSubscription(club).subscribe(
                  data => {
                    for (var sm = 0; sm < data.length; sm++) {
                      subsIdAndPriceSubs.push(data[sm].idTypeSubs + " " + data[sm].pricePerSixMonthSubscription)
                    }
                    this.dataFromEndOfficeService.retrievePerYearSubscription(club).subscribe(
                      data => {
                        for (var y = 0; y < data.length; y++) {
                          subsIdAndPriceSubs.push(data[y].idTypeSubs + " " + data[y].pricePerYearSubscription)
                        }
                      }
                    )
                    this.dataFromEndOfficeService.retrievePromotion(club).subscribe(
                      data => {
                        for (var p = 0; p < data.length; p++) {
                          subsIdAndPriceSubs.push(data[p].idTypeSubs + " " + data[p].pricePromotion)
                        }
                        for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                        }

                        this.dataFromEndOfficeService.retrieveDateSubscrioptionAndIdTypeSubscription(club).subscribe(
                          data => {
                            for (var i = 0; i < data.length; i++) {
                              let dateSubscription = JSON.stringify(data[i]).split(",")[0]
                              let idSubscription = JSON.stringify(data[i]).split(",")[1]

                              let tailleDate = JSON.stringify(data[i]).split(",")[0].length
                              let tailleIdSubscription = idSubscription.length

                              let dateSubscriptionFinal = dateSubscription.slice(2, tailleDate - 1).slice(0, 10)
                              let idTypeSubscription = idSubscription.slice(0, tailleIdSubscription - 1)


                              let yearSubs = pipe.transform(dateSubscriptionFinal, 'yyyy')
                              if (yearSubs === year) {
                                let body = pipe.transform(dateSubscriptionFinal, 'MM') + " " + idTypeSubscription
                                monthAndIdSubscription.push(body)
                              }
                            }
                            let jan = 0, fev = 0, mars = 0, avr = 0, mai = 0, jui = 0, jul = 0, aout = 0, sep = 0, oct = 0, nov = 0, dec = 0

                            for (var y = 0; y < monthAndIdSubscription.length; y++) {
                              let month = monthAndIdSubscription[y].split(" ")[0]
                              let id = monthAndIdSubscription[y].split(" ")[1]

                              if (month === "01") {
                                for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                                  if (id === subsIdAndPriceSubs[taille].split(" ")[0]) {
                                    jan = jan + parseInt(subsIdAndPriceSubs[taille].split(" ")[1])
                                  }
                                }
                              }
                              if (month === "02") {
                                for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                                  if (id === subsIdAndPriceSubs[taille].split(" ")[0]) {
                                    fev = fev + parseInt(subsIdAndPriceSubs[taille].split(" ")[1])
                                  }
                                }
                              }
                              if (month === "03") {
                                for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                                  if (id === subsIdAndPriceSubs[taille].split(" ")[0]) {
                                    mars = mars + parseInt(subsIdAndPriceSubs[taille].split(" ")[1])
                                  }
                                }
                              }
                              if (month === "04") {
                                for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                                  if (id === subsIdAndPriceSubs[taille].split(" ")[0]) {
                                    avr = avr + parseInt(subsIdAndPriceSubs[taille].split(" ")[1])
                                  }
                                }
                              }
                              if (month === "05") {
                                for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                                  if (id === subsIdAndPriceSubs[taille].split(" ")[0]) {
                                    mai = mai + parseInt(subsIdAndPriceSubs[taille].split(" ")[1])
                                  }
                                }
                              }
                              if (month === "06") {
                                for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                                  if (id === subsIdAndPriceSubs[taille].split(" ")[0]) {
                                    jui = jui + parseInt(subsIdAndPriceSubs[taille].split(" ")[1])
                                  }
                                }
                              }
                              if (month === "07") {
                                for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                                  if (id === subsIdAndPriceSubs[taille].split(" ")[0]) {
                                    jul = jul + parseInt(subsIdAndPriceSubs[taille].split(" ")[1])
                                  }
                                }
                              }
                              if (month === "08") {
                                for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                                  if (id === subsIdAndPriceSubs[taille].split(" ")[0]) {
                                    aout = aout + parseInt(subsIdAndPriceSubs[taille].split(" ")[1])
                                  }
                                }
                              }
                              if (month === "09") {
                                for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                                  if (id === subsIdAndPriceSubs[taille].split(" ")[0]) {
                                    sep = sep + parseInt(subsIdAndPriceSubs[taille].split(" ")[1])
                                  }
                                }
                              }
                              if (month === "10") {
                                for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                                  if (id === subsIdAndPriceSubs[taille].split(" ")[0]) {
                                    oct = oct + parseInt(subsIdAndPriceSubs[taille].split(" ")[1])
                                  }
                                }
                              }
                              if (month === "11") {
                                for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                                  if (id === subsIdAndPriceSubs[taille].split(" ")[0]) {
                                    nov = nov + parseInt(subsIdAndPriceSubs[taille].split(" ")[1])
                                  }
                                }
                              }
                              if (month === "12") {
                                for (var taille = 0; taille < subsIdAndPriceSubs.length; taille++) {
                                  if (id === subsIdAndPriceSubs[taille].split(" ")[0]) {
                                    dec = dec + parseInt(subsIdAndPriceSubs[taille].split(" ")[1])
                                  }
                                }
                              }
                            }

                            this.barChartData = [
                              { data: [jan, fev, mars, avr, mai, jui, jul, aout, sep, oct, nov, dec, 0], label: 'Montant gagné par mois (Dirham)' }
                            ];
                          }
                        )
                      }
                    )
                  }
                )
              }
            )
          }
        )
      }
    )
  }
}
