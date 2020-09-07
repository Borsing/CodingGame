package fairnumbering

import spock.lang.Specification
import spock.lang.Unroll

class FairNumberingSpec extends Specification {
    
    @Unroll
    void "Book with pages #firstPage to #lastPage wait the expected split page at #expectedSplitPage"() {
        when:
        def fairSplitPage = FairNumbering.findFairPage(firstPage, lastPage)

        then: 
        fairSplitPage == expectedFairSplitPage

        where:
        firstPage | lastPage | expectedFairSplitPage
        1         | 200      | 118
        8         | 10       | 9
        9         | 10       | 9
        8         | 11       | 9
        4         | 10       | 7
        4         | 11       | 8
        4         | 12       | 9
        4         | 13       | 9
        4         | 14       | 10
        3         | 15       | 10
        3         | 16       | 10
        3         | 17       | 11
        2         | 10       | 6
        99        | 100      | 99
        98        | 100      | 98
        97        | 101      | 99
        1         | 1002     | 519
        9         | 1002     | 520
        10        | 1002     | 521
        4         | 1000000  | 509259
        5         | 1000000  | 509259
        6         | 1000000  | 509259
        9         | 1000000  | 509259
        10        | 1000000  | 509259
        11        | 1000000  | 509259
        42        | 145650   | 78508
        5         | 216183   | 117350
        16        | 343151   | 180836
        93        | 871559   | 445052
        28        | 319457   | 168991
        1         | 571984   | 295250
        74        | 502960   | 260750
        8         | 611597   | 315057
        38        | 743651   | 381089
        98        | 978812   | 498680
        73        | 268847   | 143693
        60        | 424642   | 221588
        44        | 581041   | 299785
        40        | 787051   | 402790
        65        | 348855   | 183696
        97        | 617744   | 318146
        32        | 845561   | 432043
        24        | 725969   | 372246
        76        | 329829   | 174185
        77        | 943618   | 481079
        16        | 308888   | 163704
        93        | 653731   | 336138
        5         | 811752   | 415135
        24        | 605254   | 311888
        36        | 787166   | 402846
        86        | 436309   | 227426
        12        | 144065   | 77551
        71        | 627116   | 322827
        70        | 952205   | 485372
        81        | 519778   | 269160
        63        | 806211   | 412373
        59        | 663973   | 341254
        36        | 840602   | 429564
        32        | 837379   | 427952
        68        | 78803    | 40524
        36        | 918789   | 468658
        38        | 55466    | 28850
        43        | 295094   | 156812
        29        | 972392   | 495458
        52        | 355841   | 187187
        35        | 378966   | 198746
        54        | 991992   | 505262
        58        | 653644   | 336089
        43        | 889777   | 454153
        78        | 3815     | 2064
        21        | 246347   | 132434
        88        | 303640   | 161092
        71        | 287374   | 152956
        59        | 89049    | 45645
        48        | 337904   | 178217
        89        | 480763   | 249654
        67        | 645812   | 332175
        61        | 660636   | 339586
        31        | 914478   | 466502
        56        | 882036   | 450285
        25        | 72161    | 37195
        66        | 945230   | 481883
        60        | 417545   | 218040
        68        | 516435   | 267486
        69        | 118772   | 62386
        28        | 634433   | 326479
        61        | 114698   | 59940
        5         | 931515   | 475016
        81        | 948462   | 483502
        72        | 247931   | 133235
        53        | 6077     | 3188
        99        | 243107   | 130827
        57        | 459572   | 239053
        58        | 743472   | 381003
        92        | 358958   | 188752
        89        | 497999   | 258272
        86        | 423754   | 221149
        98        | 992202   | 505375
        93        | 263531   | 141038
        64        | 69083    | 35663
        64        | 937817   | 478177
        31        | 549601   | 284063
        69        | 598532   | 308535
        66        | 675248   | 346892
        33        | 410985   | 214755
        47        | 95299    | 48768
        79        | 910158   | 464350
        55        | 659725   | 339129
        33        | 503143   | 260834
        92        | 787884   | 403215
        75        | 917595   | 468067
        35        | 944063   | 481295
        2         | 708576   | 363546
        66        | 229006   | 123771
        16        | 210818   | 114669
        83        | 588776   | 303659
        96        | 73731    | 37994
        23        | 527306   | 272914
        20        | 39261    | 20744
        19        | 30651    | 16438
        35        | 579811   | 299169
        29        | 370805   | 194665
        37        | 443974   | 231251
        99        | 340413   | 179480
        5         | 579570   | 299044
        94697     | 2017500  | 1121141
        68968     | 2032495  | 1119449
        50182     | 2077351  | 1135168
        3934      | 1003903  | 512754
        18541     | 4053523  | 2111954
        82132     | 1084309  | 591734
        85359     | 1000727  | 544323
        21892     | 3045536  | 1609157
        77566     | 1097496  | 597524
        32804     | 93666    | 63234
        84414     | 2036471  | 1126954
        10054     | 1005996  | 516019
        61524     | 3016268  | 1608677
        67760     | 3012932  | 1609236
        7145      | 13262    | 10488
        54862     | 4031061  | 2113695
        24984     | 3001338  | 1588162
        74523     | 2060932  | 1135652
        47747     | 3075505  | 1633375
        24201     | 82173    | 53186
        23681     | 2034251  | 1104153
        92432     | 4033151  | 2128157
        68027     | 2086478  | 1146105
        16070     | 3083358  | 1625989
        37170     | 4035018  | 2109354
        47465     | 4039874  | 2115459
        26891     | 2089045  | 1132697
        93573     | 1038790  | 569949
        8481      | 3017027  | 1590221
        98746     | 3053786  | 1640730
        86213     | 89186    | 87699
        73876     | 89347    | 81611
        26654     | 3002120  | 1589150
        54337     | 57425    | 55880
        48828     | 1085388  | 578487
        55943     | 4068746  | 2132923
        68966     | 1012491  | 544355
        13860     | 63671    | 38765
        55147     | 2082998  | 1139765
        66723     | 3037473  | 1621137
        93446     | 1047741  | 575117
        13981     | 1040032  | 537510
        95117     | 4012404  | 2118743
        43556     | 2083628  | 1135940
        34187     | 1020830  | 534728
        13305     | 4030424  | 2098534
        34254     | 4001044  | 2091326
        14036     | 1087116  | 564998
        24707     | 35487    | 30096
        88621     | 2013363  | 1116902
        66784     | 2000759  | 1102801
        37256     | 50533    | 43894
        69374     | 1084058  | 586272
        76885     | 1041846  | 564778
        30134     | 3008361  | 1593513
        94702     | 3005064  | 1614925
        32719     | 3066116  | 1623314
        94669     | 2079166  | 1151964
        42379     | 4046973  | 2117192
        32229     | 84263    | 58245
        82270     | 2014893  | 1115399
        4026      | 4023211  | 2092041
        37006     | 1079373  | 570053
        44431     | 4065507  | 2127192
        94909     | 4024040  | 2124487
        61175     | 4029795  | 2115316
        48470     | 1053649  | 559824
        58911     | 85860    | 72385
        46563     | 2072875  | 1131638
        29383     | 84805    | 57093
        15099     | 51370    | 33234
        20470     | 2025236  | 1098499
        27822     | 2044796  | 1110905
        5764      | 2036047  | 1098955
        56828     | 3065609  | 1631671
        24311     | 4027630  | 2101068
        39345     | 75099    | 57221
        86067     | 1048572  | 572527
        52430     | 83734    | 68081
        23733     | 2090443  | 1132268
        91627     | 3006142  | 1614365
        39427     | 4047733  | 2116518
        71524     | 2020555  | 1114392
        87322     | 2029661  | 1124587
        58975     | 2049791  | 1124528
        66454     | 3023323  | 1613966
        38328     | 1093621  | 578915
        80344     | 2038800  | 1126665
        47857     | 1008227  | 533072
        67628     | 3064191  | 1634819
        61523     | 2037347  | 1119216
        48939     | 4089720  | 2140909
        59756     | 3021038  | 1610431
        37239     | 1078031  | 569367
        75197     | 1054507  | 571460
        5961      | 2020703  | 1091339
        86963     | 1033679  | 564213
        30629     | 1048059  | 549129
        17216     | 4080716  | 2125077
        94675     | 4075607  | 2150186
        6         | 159751   | 86961
        8         | 625680   | 322099
        5         | 982586   | 500552
        4         | 493892   | 256205
        9         | 745838   | 382178
        10        | 892036   | 455277
        2         | 540753   | 279635
        8         | 839857   | 429187
        7         | 936886   | 477702
        9         | 161879   | 88238
        3         | 197393   | 107955
        3         | 387390   | 202953
        1         | 738638   | 378577
        4         | 609744   | 314131
        4         | 224718   | 121618
        2         | 169634   | 92891
        7         | 375870   | 197194
        5         | 907233   | 462875
        8         | 367062   | 192790
        2         | 58522    | 30371
        3         | 517227   | 267872
        7         | 667685   | 343101
        10        | 753394   | 385956
        10        | 121775   | 64176
        7         | 656466   | 337492
        5         | 981923   | 500220
        8         | 211492   | 115005
        7         | 963061   | 490789
        5         | 432778   | 225648
        5         | 933387   | 475952
        7         | 874217   | 446367
        2         | 266503   | 142510
        6         | 681476   | 349997
        7         | 762549   | 390533
        1         | 859254   | 438885
        5         | 480526   | 249522
        6         | 638540   | 328529
        5         | 5159     | 2718
        7         | 968829   | 493673
        1         | 715385   | 366951
        7         | 441158   | 229838
        3         | 867917   | 443217
        1         | 727910   | 373213
        7         | 832772   | 425645
        6         | 387891   | 203204
        5         | 623040   | 320779
        3         | 424408   | 221462
        4         | 734195   | 376356
        4         | 399788   | 209153
        5         | 180226   | 99246
        4         | 53487    | 27854
        3         | 334613   | 176565
        3         | 174179   | 95618
        4         | 578686   | 298602
        5         | 821893   | 420205
        4         | 730115   | 374316
        2         | 850855   | 434686
        1         | 564554   | 291535
        2         | 973419   | 495968
        8         | 51616    | 26919
        6         | 600286   | 309402
        9         | 291429   | 154973
        4         | 146606   | 79074
        1         | 545560   | 282038
        6         | 567753   | 293135
        7         | 631163   | 324840
        1         | 127508   | 67615
        1         | 785314   | 401915
        8         | 587077   | 302797
        9         | 696222   | 357370
        4         | 522846   | 270682
        10        | 763712   | 391115
        7         | 372871   | 195694
        6         | 978060   | 498289
        3         | 651974   | 335245
        3         | 294012   | 156264
        7         | 942941   | 480729
        7         | 385197   | 201857
        5         | 230464   | 124491
        7         | 921899   | 470208
        3         | 406321   | 212419
        9         | 352980   | 185749
        4         | 11322    | 5965
        6         | 862187   | 440352
        9         | 638470   | 328494
        5         | 102971   | 52893
        2         | 919773   | 469145
        5         | 890405   | 454461
        1         | 132027   | 70326
        1         | 110281   | 57279
        10        | 899403   | 458961
        4         | 162829   | 88808
        10        | 975493   | 497006
        7         | 919501   | 469009
        6         | 237217   | 127867
        10        | 989279   | 503899
        9         | 996662   | 507590
        4         | 45633    | 23927
        4         | 108788   | 56383
        8         | 685794   | 352156
        6         | 89146    | 45684
        8         | 85961    | 44091
        9         | 454549   | 236533
        1         | 195366   | 106941
        9         | 193942   | 106230
        4         | 242163   | 130340
        9         | 949199   | 483858
        3         | 705735   | 362126
        5         | 714026   | 366272
        2         | 351863   | 185190
        1         | 572133   | 295325
        10        | 982889   | 500704
        3         | 387821   | 203169
        10        | 785462   | 401990
        8         | 281110   | 149814
        6         | 549819   | 284168
        1         | 460341   | 239429
        10        | 196349   | 107434
        9         | 329051   | 173784
        7         | 760822   | 389670
        5         | 105262   | 54268
        2         | 173888   | 95443
        4         | 578277   | 298397
        7         | 462365   | 240441
        9         | 593055   | 305786
        4         | 108193   | 56026
        9         | 652577   | 335547
        2         | 708541   | 363529
        6         | 263147   | 140832
        3         | 186920   | 102718
        4         | 252277   | 135397
        6         | 790443   | 404480
        1         | 177867   | 97830
        9         | 691018   | 354768
        2         | 434114   | 226315
        6         | 296586   | 157552
        3         | 445334   | 231925
        5         | 99940    | 51081
        6         | 198434   | 108476
        2         | 627524   | 323020
        2         | 918140   | 468328
        3         | 932984   | 475750
        5         | 949392   | 483955
        6         | 926452   | 472485
        2         | 904949   | 461733
        4         | 912208   | 465363
        8         | 965122   | 491820
        1         | 969606   | 494061
        8         | 913558   | 466038
        7         | 963977   | 491247
        5         | 957018   | 487768
        7         | 996594   | 507556
        6         | 944387   | 481452
        2         | 986673   | 502595
        3         | 932083   | 475300
        3         | 943045   | 480781
        4         | 901470   | 459994
        9         | 972838   | 495678
        7         | 962698   | 490608
        2         | 932799   | 475658
        4         | 940048   | 479283
        6         | 946394   | 482456
        10        | 936928   | 477723
        5         | 997236   | 507877
        10        | 907809   | 463164
        1         | 934735   | 476626
        4         | 987413   | 502965
        7         | 968166   | 493342
        4         | 980346   | 499432
        10        | 995355   | 506937
        3         | 995693   | 507105
        9         | 962156   | 490337
        9         | 993514   | 506016
        3         | 902469   | 460493
        6         | 972686   | 495602
        9         | 972335   | 495426
        9         | 995325   | 506921
        9         | 964869   | 491693
        6         | 977728   | 498123
        3         | 911239   | 464878
        9         | 987302   | 502910
        3         | 988167   | 503342
        3         | 985675   | 502096
        1         | 989985   | 504251
        5         | 993974   | 506246
        8         | 941576   | 480047
        7         | 973052   | 495785
        2         | 988155   | 503336
        6         | 947554   | 483036
        10        | 952823   | 485671
        8         | 993311   | 505914
        2         | 923846   | 471181
        8         | 941536   | 480027
        1         | 993717   | 506117
        7         | 983270   | 500894
        5         | 995651   | 507084
        7         | 914826   | 466672
        1         | 913269   | 465893
        7         | 903296   | 460907
        4         | 922246   | 470382
        2         | 946745   | 482631
        1         | 906140   | 462328
        6         | 930914   | 474716
        3         | 923670   | 471093
        6         | 907530   | 463024
        5         | 928865   | 473691
        10        | 940001   | 479260
        7         | 983914   | 501216
        5         | 974012   | 496265
        10        | 925550   | 472034
        3         | 980053   | 499285
        9         | 944812   | 481665
        9         | 980464   | 499491
        1         | 930012   | 474264
        6         | 958424   | 488471
        3         | 961754   | 490135
        6         | 957735   | 488126
        7         | 926138   | 472328
        6         | 933796   | 476157
        2         | 936447   | 477482
        3         | 987719   | 503118
        9         | 996359   | 507438
        4         | 995384   | 506951
        1         | 903774   | 461145
        9         | 979350   | 498934
        2         | 908115   | 463316
        6         | 949011   | 483764
        9         | 944615   | 481566
        9         | 949852   | 484185
        3         | 988641   | 503579
        6         | 929975   | 474246
        5         | 923903   | 471210
        2         | 967621   | 493069
        3         | 933928   | 476222
        8         | 971943   | 495230
        8         | 970748   | 494633
        6         | 923132   | 470825
        10        | 947372   | 482945
        4         | 999944   | 509231
        8         | 964454   | 491486
        5         | 983121   | 500819
        1         | 934505   | 476511
        1         | 960515   | 489516
        3         | 931255   | 474886
        8         | 957844   | 488181
        6         | 940616   | 479567
        10        | 965825   | 492172
        5         | 966555   | 492536
        4         | 934486   | 476502
        3         | 901320   | 459918
        8         | 922477   | 470497
        10        | 954321   | 486420
        7         | 958254   | 488386
        5         | 961174   | 489846
        7         | 929557   | 474037
        4         | 937671   | 478094
        4         | 912882   | 465700
        3         | 907604   | 463060
        4         | 944297   | 481407
        8         | 987553   | 503035
        4         | 4082185  | 2120457
        7         | 4003050  | 2080890
        3         | 4064795  | 2111762
        4         | 4029737  | 2094233
        9         | 4083251  | 2120990
        6         | 4087480  | 2123104
        8         | 4031180  | 2094955
        6         | 4080755  | 2119742
        3         | 4084877  | 2121803
        6         | 4023534  | 2091131
        5         | 4020619  | 2089674
        1         | 4052070  | 2105399
        3         | 4056428  | 2107578
        9         | 4013081  | 2085905
        1         | 4058085  | 2108407
        3         | 4019217  | 2088973
        9         | 4085284  | 2122007
        6         | 4053499  | 2106114
        9         | 4010826  | 2084778
        3         | 4092726  | 2125727
        8         | 4099184  | 2128957
        1         | 4077415  | 2118072
        8         | 4043626  | 2101178
        2         | 4027817  | 2093273
        8         | 4047401  | 2103065
        10        | 4034370  | 2096550
        3         | 4047259  | 2102994
        2         | 4040049  | 2099389
        1         | 4036557  | 2097643
        4         | 4047844  | 2103286
        2         | 4019088  | 2088908
        1         | 4018342  | 2088535
        1         | 4019673  | 2089201
        4         | 4002644  | 2080686
        4         | 4034435  | 2096582
        2         | 4006353  | 2082541
        7         | 4045167  | 2101948
        4         | 4078319  | 2118524
        6         | 4040139  | 2099434
        6         | 4001838  | 2080283
        3         | 4076369  | 2117549
        5         | 4045154  | 2101941
        6         | 4037318  | 2098023
        2         | 4086316  | 2122522
        9         | 4029603  | 2094166
        4         | 4008907  | 2083818
        9         | 4058224  | 2108477
        8         | 4021419  | 2090074
        6         | 4037900  | 2098314
        9         | 4036123  | 2097426
        27        | 3747274  | 1953004
        60        | 2470023  | 1314383
        94        | 7763287  | 3961020
        33        | 4044917  | 2101827
        60        | 6265233  | 3211988
        9         | 1047615  | 537034
        12        | 3622566  | 1890648
        94        | 9240628  | 4699691
        19        | 6581401  | 3370067
        49        | 7263336  | 3711038
        80        | 2052916  | 1105833
        46        | 8652195  | 4405467
        10        | 3555083  | 1856906
        43        | 5899589  | 3029164
        32        | 6463506  | 3311121
        62        | 9707551  | 4933148
        8         | 7078491  | 3618610
        60        | 594870   | 306702
        22        | 8051011  | 4104872
        97        | 2734390  | 1446572
        40        | 3305822  | 1732280
        90        | 2990343  | 1574548
        92        | 6072229  | 3115491
        26        | 2244358  | 1201546
        31        | 9329280  | 4744008
        27        | 4313630  | 2236182
        12        | 302703   | 160611
        49        | 8067000  | 4112870
        3         | 2959195  | 1558962
        51        | 1664519  | 896902
        25        | 4921634  | 2540184
        92        | 9962593  | 5060673
        55        | 554987   | 286760
        91        | 117862   | 61845
        60        | 8661637  | 4410190
        34        | 7870716  | 4014726
        38        | 5523494  | 2841116
        63        | 3491649  | 1825197
        68        | 5530513  | 2844630
        86        | 139470   | 74808
        84        | 9823089  | 4990920
        80        | 4974895  | 2566822
        77        | 9481844  | 4820296
        57        | 8543262  | 4351002
        82        | 6237685  | 3198218
        91        | 3417193  | 1787973
        80        | 4467898  | 2313324
        48        | 7084503  | 3621622
        63        | 2409112  | 1283928
        97        | 3209139  | 1683947
    }
}